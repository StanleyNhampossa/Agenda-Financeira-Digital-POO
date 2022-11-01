
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

// conexao a banco de dados 
public class Conectar {
    
    private static final String usuario = "root";
    private static final String senha = "";
    private static final String url = "jdbc:mysql://localhost/gestaofinanceira";
    
    public static Connection getConection(){
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao=DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERRO NA CONEXAO"+ex.getMessage());
        }
        
        return conexao;
   
    } 
    
   public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            closeConnection(connection);
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            closeConnection(connection, statement);
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
}
