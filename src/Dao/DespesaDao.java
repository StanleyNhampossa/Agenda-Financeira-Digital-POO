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
        String sql = "INSERT INTO despesas (tipoDespesa, custo, categoria, utilizador_id) VALUES(?, ?, ?, ?)";
        
        try{
            Connection con=Conectar.getConection();
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setString(1, p.getTipoDespesa());
            smt.setDouble(2, p.getCusto());
            smt.setString(3, p.getCategoria());   
            smt.setInt(4, p.getUtilizador_id());
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
     */
    public static boolean actualizar(Despesa p){        
        String sql="UPDATE  despesas SET tipoDespesa = ?, custo = ?, categoria = ? WHERE id = ? AND utilizador_id = ?";
        
        try{
           Connection con=Conectar.getConection();
           PreparedStatement smt= con.prepareStatement(sql);
           smt.setString(1, p.getTipoDespesa());
           smt.setDouble(2, p.getCusto());
           smt.setString(3, p.getCategoria());
           smt.setInt(4, p.getId());
           smt.setInt(5, p.getUtilizador_id());
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
     */
    public static boolean excluir(Despesa p){             
        String sql = "DELETE FROM despesas WHERE id = ?";     
        
        try{
            Connection con = Conectar.getConection();
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1,p.getId());
            smt.executeUpdate();
            Conectar.closeConnection(con, smt);
            
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir o registro");
        }
        
        return false;
    }
    
    /**
     * Faz a listagem de todas as despesas que estão na base de dados
     * @return a lista de despesas cadastradas
     */
    public static List<Despesa> listar(){        
        List<Despesa> lista = new ArrayList<>();
        String sql = "SELECT * FROM despesas WHERE utilizador_id = ? ORDER BY categoria";// para ordenar atraves da CATEGORIA de DESPESA
        
        try{
            Connection con = Conectar.getConection();
            PreparedStatement smt = con.prepareStatement(sql);
            smt.setInt(1, MenuView.user.getId());
            ResultSet resulto = smt.executeQuery();
            while(resulto.next()){
                Despesa p = new Despesa();
                p.setId(resulto.getInt("id"));
                p.setTipoDespesa(resulto.getString("tipoDespesa"));
                p.setCusto(resulto.getDouble("custo"));
                p.setCategoria(resulto.getString("categoria"));
                p.setUtilizador_id(resulto.getInt("utilizador_id"));
                lista.add(p);
            }
       }catch(Exception ex){
          JOptionPane.showMessageDialog(null,"Erro ao buscar o registro");  
       }
     
       return lista;//vai nos retornar a lista
    }
}
