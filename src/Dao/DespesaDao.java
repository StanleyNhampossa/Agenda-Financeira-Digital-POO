/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Banco.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Despesa;
import view.EmuladorDeGastos.SimuladorDeGastos;
import view.menu.MenuView;


/**
 *Classe responsável por estabelecer a comunicação entre a tela de despesas
 * com a tabela de despesas na base de dados
 * @author Massingue
 */
public class DespesaDao {
     
    /**
     * Realiza o cadastro de despesas na base de dados
     * @param p a despesa a ser cadastrada
     */
    public static boolean cadastrar(Despesa p){        
        String sql = "INSERT INTO despesas (tipoDespesa, custo, categoria, utilizador_id,prioridade) VALUES(?, ?, ?, ?,?)";
        
        try{
            Connection con=Conectar.getConection();
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, p.getTipoDespesa());
            smt.setDouble(2, p.getCusto());
            smt.setString(3, p.getCategoria());   
            smt.setInt(4, p.getUtilizador_id());
            smt.setString(5,p.getPrioridade());
            smt.executeUpdate();
            Conectar.closeConnection(con, smt);
            
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+ex.getMessage());            
        }
        
        return false;
    }
    
    /**
     * Faz a actualização de despesas na base de dados
     * @param p a despesa a ser actualizada
     * @return 
     */
    public static boolean actualizar(Despesa p){        
        String sql = "UPDATE  despesas SET tipoDespesa = ?, custo = ?, categoria = ?,prioridade=? WHERE id = ? AND utilizador_id = ?";
       
        try{
           Connection con=Conectar.getConection();
           PreparedStatement smt= con.prepareStatement(sql);
           smt.setString(1, p.getTipoDespesa());
           smt.setDouble(2, p.getCusto());
           smt.setString(3, p.getCategoria());
           smt.setString(4, p.getPrioridade());
           smt.setInt(5, p.getId());
           smt.setInt(6, p.getUtilizador_id());           
           smt.executeUpdate();
           Conectar.closeConnection(con, smt);
           
           return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"erro ao actualiar o registro"+ex.getMessage());
        }   
        
        return false;
    }
     public static boolean actualizarCusto(Despesa p){        
        String sql = "UPDATE  despesas SET  custo = ? WHERE id = ? AND utilizador_id = ?";
       
        try{
           Connection con=Conectar.getConection();
           PreparedStatement smt= con.prepareStatement(sql);
           smt.setDouble(1, p.getCusto());
           smt.setInt(2,SimuladorDeGastos.despesaGasto.getId());
           smt.setInt(3, MenuView.user.getId());
             smt.executeUpdate();
           Conectar.closeConnection(con, smt);
           
           return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"erro ao actualiar o registro"+ex.getMessage());
        }   
        
        return false;
    }
    /**
     * Realiza a exclusão de despesas na base de dados
     * @param p a despesa a ser excluída
     * @return 
     */
    public static boolean excluir(Despesa p){             
        String sql = "DELETE FROM despesas WHERE id = ?";     
        
        try{
            Connection con = Conectar.getConection();
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, p.getId());
            smt.executeUpdate();
            Conectar.closeConnection(con, smt);
            
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir o registro");
        }
        
        return false;
    }
    
    /**
     * Faz a listagem com filtro por utilizador e por categoria(opcional) 
     * dos rendimentos que estão na base de dados
     * @param id o id do utilizador associado
     * @param chave a categoria da despesa
     * @return a lista de despesas já cadastradas para o utilizador com id igual a {@code id} e chave igual ou similar a {@code chave}
     */
    public static List<Despesa> listar(int id, String chave){        
        List<Despesa> lista = new ArrayList<>();
        String sql = "SELECT * FROM despesas WHERE utilizador_id = " + id + " ORDER BY categoria";// para ordenar atraves da CATEGORIA de DESPESA
        String sql2 = "SELECT * FROM `gestaofinanceira`.`despesas` WHERE `categoria` LIKE '" + chave + "%' AND `utilizador_id` = " + id;
        
        try{
            PreparedStatement smt = null;
            Connection con = Conectar.getConection();
            if(chave.equals(""))
                smt = con.prepareStatement(sql);
            else
                smt = con.prepareStatement(sql2);
            ResultSet resulto = smt.executeQuery();
            
            while(resulto.next()){
                Despesa p = new Despesa();
                p.setId(resulto.getInt("id"));
                p.setTipoDespesa(resulto.getString("tipoDespesa"));
                p.setCusto(resulto.getDouble("custo"));
                p.setCategoria(resulto.getString("categoria"));
                p.setUtilizador_id(resulto.getInt("utilizador_id"));
                p.setPrioridade(resulto.getString("prioridade"));
                lista.add(p);
            }
       }catch(Exception ex){
          //JOptionPane.showMessageDialog(null,"Erro ao buscar o registro");  
          ex.printStackTrace();
       }
     
       return lista;//vai nos retornar a lista
    }
}
