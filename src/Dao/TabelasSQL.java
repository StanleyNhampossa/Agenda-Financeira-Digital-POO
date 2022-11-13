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
public final class TabelasSQL {

    private static final String[] cmds = new String[7];

    /**
     * Construtor da classe: inicializa o array com os comandos de criação
     */
    private TabelasSQL() {
        cmds[0] = "CREATE DATABASE IF NOT EXISTS gestaofinanceira";

        cmds[1] = "USE gestaofinanceira";

        cmds[2] = "CREATE TABLE IF NOT EXISTS utilizadores("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "nome MEDIUMTEXT NOT NULL,"
                + "dataNascimento DATE NOT NULL,"
                + "genero VARCHAR(9) NOT NULL,"
                + "profissao MEDIUMTEXT NOT NULL,"
                + "email MEDIUMTEXT NOT NULL UNIQUE,"
                + "senha VARCHAR(15) NOT NULL,"
                + "fotoPerfil MEDIUMTEXT NOT NULL)";

        cmds[3] = "CREATE TABLE IF NOT EXISTS rendimentos("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "tipoRendimento MEDIUMTEXT,"
                + "rendimento DOUBLE,"
                + "periodo MEDIUMTEXT,"
                + "fonteRendimento MEDIUMTEXT UNIQUE,"
                + "utilizador_id INT,"
                + "FOREIGN KEY (utilizador_id) REFERENCES utilizadores(id) ON DELETE CASCADE ON UPDATE CASCADE)";

        cmds[4] = "CREATE TABLE IF NOT EXISTS despesas("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "tipoDespesa MEDIUMTEXT NOT NULL,"
                + "  `prioridade` varchar(255) NOT NULL,"
                + "custo DOUBLE,"
                + "categoria MEDIUMTEXT,"
                + "utilizador_id INT NOT NULL,"
                + "FOREIGN KEY (utilizador_id) REFERENCES utilizadores(id) ON DELETE CASCADE ON UPDATE CASCADE)";

        cmds[5] = "CREATE TABLE IF NOT EXISTS emprestimo("
                + "  `ID` int(11) NOT NULL,"
                + "  `utilizador_id` int(11) NOT NULL,"
                + "  `Titulo` varchar(256) NOT NULL,"
                + "  `Valor` double NOT NULL,"
                + "  `Taxa_de_Juros` double NOT NULL,"
                + "  `Numero_de_parcelas` int(11) NOT NULL,"
                + "  `Total_a_pagar_em_juros` double NOT NULL,"
                + "  `Valor_da_parcela` double NOT NULL,"
                + "  `Total_a_pagar` double NOT NULL,"
                + "FOREIGN KEY (utilizador_id) REFERENCES utilizadores(id) ON DELETE CASCADE ON UPDATE CASCADE)";
        cmds[6] = "CREATE TABLE IF NOT EXISTS gastos ("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "  `utilizador_id` int(11) NOT NULL,"
                + "  `valor_gasto` double NOT NULL,"
                + "  `fonte_valor` varchar(256) NOT NULL,"
                + "  `prioridade` varchar(255) NOT NULL,"
                + "  `descricao` varchar(255) NOT NULL,"
                + "  `valor_poupado` double NOT NULL,"
                + "  `categoria` varchar(256) NOT NULL,"
                + "FOREIGN KEY (utilizador_id) REFERENCES utilizadores(id) ON DELETE CASCADE ON UPDATE CASCADE)";

    }

    /**
     * Executa a criação da base de dados e das tabelas necessárias para o
     * funcionamento do programa
     *
     * @return {@code true} se a base de dados e as tabelas for executada com
     * sucesso, {@code false} em caso de falha na criação
     */
    public static boolean criarBaseDeDados() {
        Connection connection = null;
        PreparedStatement statement = null;
        new TabelasSQL();

        while (true) {
            for (int i = 0; i < 2; i++)         
                try {
                connection = Conectar.getServerHost();
                statement = connection.prepareStatement(cmds[i]);
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(TabelasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }

            Conectar.closeConnection(connection, statement);

            for (int i = 2; i < 7; i++)
                try {
                connection = Conectar.getConection();
                statement = connection.prepareStatement(cmds[i]);
                statement.execute();
            } catch (SQLException ex) {
                Logger.getLogger(TabelasSQL.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;
        }

        Conectar.closeConnection(connection, statement);

        return true;
    }

}
