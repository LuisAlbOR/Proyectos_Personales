package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Guicho
 */
public class MySQLConnection implements DatabaseConnection{

    private Connection conn = null;

    @Override
    public void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db_sistema_ventas", "root", "29072003");
        } catch (SQLException e) {
            System.out.println("Error de conexión local " + e);
        }
    }

    @Override
    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión " + e);
        }
    }

    @Override
    public Statement createStatement() {
        Statement statement = null;
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error al crear el statement " + e);
        }
        return statement;
    }
}
