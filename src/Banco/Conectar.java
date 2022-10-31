
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

// conexao a banco de dados 
public class Conectar {
    
    private static final String usuario="root";
    private static final String senha="";
    private static final String url="jdbc:mysql://localhost/gestaofinanceira";
    
    public static Connection getConectar(){
    Connection conexao=null;
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    conexao=DriverManager.getConnection(url,usuario,senha);
        System.out.println("Conectado");
    }catch(Exception ex){
    JOptionPane.showMessageDialog(null,"ERRO NA CONEXAO"+ex.getMessage());
    }
    return conexao;
   
    } 
    
   
   
}
