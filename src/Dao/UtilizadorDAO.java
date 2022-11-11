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
    
     /**
     * Realiza o cadastro de utilizadores na base de dados.
     * @param user o utilizador a ser cadastrado
     * @return {@code true} se o cadastro for executado com êxito, 
     * ou {@code false} se não for concluído com êxito
     */
    public boolean criar(Utilizador user) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        String cmd = "INSERT INTO `gestaofinanceira`.`utilizadores`(`nome`, `dataNascimento`, `genero`, `profissao`, `email`, `senha`, `fotoPerfil`)"
                   + " VALUES(?, ?, ?, ?, ?, ?, ?)";        
                
        try {
            connection = Conectar.getConection();
            statement = connection.prepareStatement(cmd);
            Date data = new Date(user.getDataNascimento().getYear(), user.getDataNascimento().getMonth(), user.getDataNascimento().getDay());
            
            statement.setString(1, user.getNome());
            statement.setDate(2, data);
            statement.setString(3, user.getGenero());
            statement.setString(4, user.getProfissao());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getSenha());
            statement.setString(7, user.getFotoPerfil());
            statement.execute();            
            Conectar.closeConnection(connection, statement);
            
            return true;            
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     * Realiza a actualização de dados de utilizador na base de dados.
     * @param user objecto com os dados a serem actualizados do utilizador
     * @return {@code true} se a ação tiver sido executada com sucesso,
     * {@code false} se a operação não for conluída
     */
    public boolean actualizar(Utilizador user) {

        Connection connection = null;
        PreparedStatement statement = null;
        String cmd = "UPDATE `gestaofinanceira`.`utilizadores` SET `nome` = ?, `dataNascimento` = ?, `genero` = ?, `profissao` = ?, `email` = ?,"
                   + " `senha` = ?, `fotoPerfil` = ? WHERE `id` = ?";
        
        try {
            connection = Conectar.getConection();
            statement = connection.prepareStatement(cmd);
            Date data = new Date(user.getDataNascimento().getYear(), user.getDataNascimento().getMonth(), user.getDataNascimento().getDay());
            
            statement.setString(1, user.getNome());
            statement.setDate(2, data);
            statement.setString(3, user.getGenero());
            statement.setString(4, user.getProfissao());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getSenha());
            statement.setString(7, user.getFotoPerfil());
            statement.setInt(8, user.getId());
            statement.executeUpdate();
            Conectar.closeConnection(connection, statement);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     * Realiza a exclusão de utilizadores na base de dados
     * @param id id do utilizador a ser excluído
     * @return {@code true} se a ação for executada com sucesso,
     * {@code false} caso contrário
     */
    public boolean apagar(int id) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        String cmd = "DELETE FROM `gestaofinanceira`.`utilizadores` WHERE `id` = '" + id + "'";
                
        try {
            connection = Conectar.getConection();
            statement = connection.prepareStatement(cmd);
            statement.execute();
            Conectar.closeConnection(connection, statement);
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UtilizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     * Realiza a autenticação de utilizadores no sistema
     * @param userEmail o email do utilizador a ser autenticado
     * @param senha a senha do utilizador a ser autenticado
     * @return uma instância da classe {@code Utilizador} contendo os dados do utilizador caso a autenticação
     * ocorra com êxito, {@code null} caso contrário
     */
    public Utilizador autenticar(String userEmail, String senha) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Utilizador user = null;
        String cmd = "SELECT * FROM `gestaofinanceira`.`utilizadores` WHERE `email` = '" + userEmail + "' AND `senha` = '" + senha + "'";
                
        try {
            connection = Conectar.getConection();
            statement = connection.prepareStatement(cmd);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                user = new Utilizador();
                user.setId(resultSet.getInt("id"));
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
