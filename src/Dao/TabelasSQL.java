package Dao;

import Banco.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grácio Macuácua
 */
public class TabelasSQL {
    
    private static String[] cmds = new String[3];
    
    private TabelasSQL() {    
        cmds[0] = "CREATE TABLE IF NOT EXISTS utilizadores(" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "nome MEDIUMTEXT NOT NULL," +
                    "dataNascimento DATE NOT NULL," +
                    "genero VARCHAR(9) NOT NULL," +
                    "profissao MEDIUMTEXT NOT NULL," +
                    "email MEDIUMTEXT NOT NULL UNIQUE," +
                    "senha VARCHAR(15) NOT NULL," +
                    "fotoPerfil MEDIUMTEXT NOT NULL)";

        cmds[1] = "CREATE TABLE IF NOT EXISTS rendimentos(" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "tipoRendimento MEDIUMTEXT," +
                    "rendimento DOUBLE," +
                    "periodo MEDIUMTEXT," +
                    "fonteRendimento MEDIUMTEXT UNIQUE," +
                    "utilizador_fk INT, " +
                    "FOREIGN KEY (utilizador_fk) REFERENCES utilizadores(id))";


        cmds[2] = "CREATE TABLE IF NOT EXISTS despesas(" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "tipoDespesa MEDIUMTEXT NOT NULL," +
                    "custo DOUBLE," +
                    "categoria MEDIUMTEXT)";    
    }
    
    public static boolean criarTabelas() {
        Connection connection = null;
        PreparedStatement statement = null;
        new TabelasSQL();
        
        for(int i = 0; i < 3; i++)
            try {
                connection = Conectar.getConection();
                statement = connection.prepareStatement(cmds[i]);
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(TabelasSQL.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        
        return true;
    }
    
}
