package Dao;

import Banco.Conectar;
import model.Utilizador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grácio Macuácua
 */
public class UtilizadorDAO {
    
    
    public boolean criar(Utilizador user) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        String cmd = "INSERT INTO tbUtilizadores VALUES(?, ?, ?, ?, ?, ?, ?)";        
                
        try {
            connection = Conectar.getConection();
            statement = connection.prepareStatement(cmd);
            
            statement.setString(1, user.getNome());
            statement.setDate(2, ((Date) user.getDataNascimento()));
            statement.setString(3, user.getGenero());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getSenha());
            statement.setString(6, user.getFotoPerfil());            
            statement.execute();            
            Conectar.closeConnection(connection, statement);
            return true;            
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean actualizar(Utilizador user) {

        Connection connection = null;
        PreparedStatement statement = null;
        String cmd = "UPDATE tbUtilizadores SET nome = ?, dataNascimento = ?, genero = ?, email = ?,"
                   + " senha = ?, fotoPerfil = ? WHERE email = ?";
        
        try {
            connection = Conectar.getConection();
            statement = connection.prepareStatement(cmd);
            
            statement.setString(1, user.getNome());
            statement.setDate(2, ((Date) user.getDataNascimento()));
            statement.setString(3, user.getGenero());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getSenha());
            statement.setString(6, user.getFotoPerfil());
            statement.setString(7, user.getEmail());
            statement.executeUpdate();
            Conectar.closeConnection(connection, statement);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean apagar(String chave) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        String cmd = "DELETE FROM tbUtilizadores WHERE email = '" + chave + "'";
                
        try {
            connection = Conectar.getConection();
            statement.execute(cmd);
            Conectar.closeConnection(connection, statement);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public Utilizador autenticar(String userEmail, String senha) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utilizador user = null;
        String cmd = "SELECT * FROM tbUtilizadores WHERE email = '" + userEmail + "' AND senha = '" + senha + "'";
                
        try {
            connection = Conectar.getConection();
            resultSet = statement.executeQuery(cmd);
            
            while(resultSet.next()) {
                user.setNome(resultSet.getString("nome"));
                user.setDataNascimento(resultSet.getDate("dataNascimento"));
                user.setGenero(resultSet.getString("genero"));
                user.setProfissao(resultSet.getString("profissao"));
                user.setEmail(resultSet.getString("email"));
                user.setSenha(resultSet.getString("senha"));
                user.setFotoPerfil(resultSet.getString("fotoPerfil"));
            }
            
            Conectar.closeConnection(connection, statement, resultSet);
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return user;
    }
}
