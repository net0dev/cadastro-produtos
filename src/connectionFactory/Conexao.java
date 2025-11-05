package connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection getConexao() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cadastro_produtos",
                    "root",
                    "Coloque a senha do seu banco aqui"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage(), e);
        }
    }
}
