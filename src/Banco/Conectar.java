
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Main;
import view.geral.Notificacao;

/**
 * Classe responsável pelo gerenciamento das conexões com a base de dados
 * 
 * @author Paulo Massingue
 */
public final class Conectar {
    
    private static final String usuario = "root";
    private static final String senha = "";
    private static final String url = "jdbc:mysql://localhost/gestaofinanceira";
    private static final String url2 = "jdbc:mysql://localhost/";    
    
    /**
     * Estabelece a conexão com a base de dados do sistema.
     * 
     * @return a conexão à base de dados se esta tiver sido estabelecida, 
     * ou {@code null} se não tiver sido estabelecida.
     */
    public static Connection getConection(){
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao=DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado");
        }catch(Exception ex){
            Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "Erro crítico na conexão:\n" + ex, Notificacao.ICONE_ERRO);
        }
        
        return conexao;
   
    } 
    
    /**
     * Estabelece uma conexão ao servidor local.
     * 
     * @return a conexão ao servidor se esta tiver sido estabelecida, ou {@code null} caso contrário
     */
    public static Connection getServerHost(){
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao=DriverManager.getConnection(url2, usuario, senha);
        }catch(Exception ex){
            Notificacao.mostrarDialogoDeOpcaoSingular(Main.main, "Erro crítico na conexão:\n" + ex, Notificacao.ICONE_ERRO);
        }
        
        return conexao;
   
    } 
    
    /**
     * Finaliza a ligação com o servidor.
     * @param connection a conexão a ser terminada.
     */
    public static void closeConnection(Connection connection) {
         try {
             connection.close();
         } catch (SQLException ex) {
             Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Finaliza o prepared statement e conexão com o servidor 
     * @param connection a conexão a ser finalizada
     * @param statement o statement a ser finalizado
     */
    public static void closeConnection(Connection connection, PreparedStatement statement) {
         try {
             closeConnection(connection);
             statement.close();
         } catch (SQLException ex) {
             Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     * Finaliza o prepared statement, o resultset e a conexão com o servidor
     * @param connection a conexão a ser finalizada
     * @param statement o statement a ser terminado
     * @param resultSet o resultset a ser terminado
     */
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
         try {
             closeConnection(connection, statement);
             resultSet.close();
         } catch (SQLException ex) {
             Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
   
}
