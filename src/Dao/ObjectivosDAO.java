/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Banco.Conectar;
import  java.sql.*;
import javax.swing.JOptionPane;
import model.ObjectivoFinanceiro;
import model.SimuladorEmprestimos;
import view.menu.MenuView;
/**
 *
 * @author berna
 */
public class ObjectivosDAO {
   
      public void guardar(ObjectivoFinanceiro objectivoFinanceiro) throws SQLException {
     Connection conexao= Conectar.getConection();
            PreparedStatement statement = null;
        try {
           
            
            statement= conexao.prepareStatement("INSERT INTO emprestimo (Titulo,Valor,Taxa_de_Juros,Numero_de_parcelas,Total_a_pagar_em_juros,Valor_da_parcela,Total_a_pagar,utilizador_id)VALUES(?,?,?,?,?,?,?,?)");
           
            
            statement.setInt(8,MenuView.user.getId());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Emprestimo salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ ex);
             }finally{
            
                   Conectar.closeConnection(conexao, statement);
                     }
    
   
    }
    
    
    
}
