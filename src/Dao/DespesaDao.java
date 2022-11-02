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
import model.Rendimento;


/**
 *
 * @author Massingue
 */
public class DespesaDao {
     //metodo  que adiciona rendimento ao banco de dados
    public void cadastrar(Despesa p){
        Connection con=Conectar.getConection();
        String sql="INSERT INTO despesa (tipoDespesa,custo,categoria) VALUES(?,?,?)";
        try(PreparedStatement smt= con.prepareStatement(sql)){
            smt.setString(1, p.getTipoDespesa());
            smt.setDouble(2, p.getCusto());
            smt.setString(3, p.getCategoria());      
            smt.executeUpdate();
            smt.close();
            con.close();// para nao sobrecarregar o sistema
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar"+ex.getMessage());            
        }
    }
    
     public void actualizar(Despesa p){
         // metodo para actualizar 
        Connection con=Conectar.getConection();
        String sql="UPDATE  despesa SET tipoDespesa=?,custo=?,categoria=? WHERE id=?";
        try(PreparedStatement smt= con.prepareStatement(sql)){
           smt.setString(1, p.getTipoDespesa());
           smt.setDouble(2, p.getCusto());
           smt.setString(3, p.getCategoria());
           smt.setInt(4,p.getId());
           smt.executeUpdate();
           smt.close();
           con.close();// para nao sobrecarregar o sistema
           JOptionPane.showMessageDialog(null,"Actualizado com sucesso!");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"erro ao actualiar o registro"+ex.getMessage());
    }   
        
    }
      public void excluir(Despesa p){
         // metodo para excluir dados no banco de dados
     
        Connection con =Conectar.getConection();
        String sql="DELETE FROM despesa WHERE id=?";
        int opcao=JOptionPane.showConfirmDialog(null,"Deseja exluir o rendimento "+p.getCategoria()+" ?","Exluir",JOptionPane.YES_NO_OPTION);
        if(opcao==JOptionPane.YES_NO_OPTION){
            try(PreparedStatement smt= con.prepareStatement(sql)){
                smt.setInt(1,p.getId());
                smt.executeUpdate();
                smt.close();
                con.close();
                JOptionPane.showMessageDialog(null,"Excluido com sucesso");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao excluir o registro");
            }
        }
     }
     public List<Despesa> listar(){
        Connection con =Conectar.getConection();
        List<Despesa> lista=new ArrayList<>();

        String sql="SELECT * FROM despesa ORDER BY categoria";// para ordenar atraves da CATEGORIA de DESPESA
        try(PreparedStatement smt =con.prepareStatement(sql)){
          ResultSet resulto=smt.executeQuery();
          while (resulto.next()){
            Despesa p =new Despesa();
              p.setId(resulto.getInt("id"));
              p.setTipoDespesa(resulto.getString("tipoDespesa"));
              p.setCusto(resulto.getDouble("custo"));
              p.setCategoria(resulto.getString("Categoria"));
              lista.add(p);
          }
       }catch(Exception ex){
          JOptionPane.showMessageDialog(null,"Erro ao buscar o registro");  
       }
     
       return lista;//vai nos retornar a lista
  }
}
