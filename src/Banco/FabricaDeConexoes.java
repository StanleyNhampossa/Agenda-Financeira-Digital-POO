/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author berna
 */
public class FabricaDeConexoes {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/sgfdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {

        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }

    public static void closeConnection(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao encerrar conexão", ex);
            }

        }
    }

    public static void closeConnection(Connection conexao, PreparedStatement statement) {
        closeConnection(conexao);
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao encerrar conexão", ex);
        }

    }

    public static void closeConnection(Connection conexao, PreparedStatement statement, ResultSet resultSet) {
        closeConnection(conexao, statement);

        {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao encerrar conexão", ex);
            }

        }
    }

}
