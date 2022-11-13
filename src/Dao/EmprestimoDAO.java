/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Banco.Conectar;
import Banco.FabricaDeConexoes;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.SimuladorEmprestimos;
import view.Main;
import view.emuladordeemprestimos.PainelEmuladorDeEmprestimos;
import view.menu.MenuView;

/**
 *
 * @author berna
 */
public class EmprestimoDAO {
    
    public static void guardar(SimuladorEmprestimos emprestimo) throws SQLException  {
     Connection conexao= Conectar.getConection();
            PreparedStatement statement = null;
        try {
           
            
            statement= conexao.prepareStatement("INSERT INTO despesas (tipoDespesa,prioridade,custo,categoria,utilizador_id)VALUES(?,?,?,?,?)");
            statement.setString(1, "Fixa");
            statement.setString(2, "Emergencia");
            statement.setDouble(3, PainelEmuladorDeEmprestimos.receptaculoEmprestimos.getDivida());
            statement.setString(4, "Emprestimo - "+PainelEmuladorDeEmprestimos.receptaculoEmprestimos.getTitulo());
            statement.setInt(5, MenuView.user.getId());
            
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Emprestimo adicionado as Despesas");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar"+ ex);
             }finally{
            
                    FabricaDeConexoes.closeConnection(conexao, statement);
                     }
    
   
    }
    
}
