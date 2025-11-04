package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/exemplodb",
                    "root",
                    "Cafe1209"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage(), e);
        }
    }
}
