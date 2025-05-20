package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/Hoteldb";
    private static final String usuario = "dbaHotel";
    private static final String senha = "dbaHotel123";

    public Connection conectar() {
        Connection condb = null;

        try {
            Class.forName(driver);
            condb = DriverManager.getConnection(url, usuario, senha);
            return condb;
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver JDBC não encontrado. " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao Banco de Dados: " + e.getMessage());
            return null;
        }
    }

    public void fecharConexao(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o Banco de Dados: " + e.getMessage());
            }
        }
    }
}