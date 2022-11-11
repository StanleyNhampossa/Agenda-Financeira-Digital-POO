/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Banco.FabricaDeConexoes;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.SimuladorEmprestimos;

/**
 *
 * @author berna
 */
public class EmprestimoDAO {
    
    public void guardar(SimuladorEmprestimos emprestimo) throws SQLException {
     Connection conexao= FabricaDeConexoes.getConnection();
            PreparedStatement statement = null;
        try {
           
            
            statement= conexao.prepareStatement("INSERT INTO emprestimo (Titulo,Valor,Taxa_de_Juros,Numero_de_parcelas,Total_a_pagar_em_juros,Valor_da_parcela,Total_a_pagar)(?,?,?,?,?,?,?)");
            statement.setString(1, emprestimo.getTitulo());
            statement.setDouble(2, emprestimo.getCapital());
            statement.setDouble(3, emprestimo.getTaxaDeJuros());
            statement.setInt(4, emprestimo.getnParcelas());
            statement.setDouble(5, emprestimo.getJuros());
            statement.setDouble(6, emprestimo.getValorParcela());
            statement.setDouble(7, emprestimo.getDivida());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Emprestimo salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ ex);
             }finally{
            
                    FabricaDeConexoes.closeConnection(conexao, statement);
                     }
    
   
    }
    
}
