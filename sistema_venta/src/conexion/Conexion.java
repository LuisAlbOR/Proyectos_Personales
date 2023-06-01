package conexion;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Guicho
 */
public class Conexion {
    
    public static Connection Conexion (){
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db_sistema_ventas", "root", "29072003");
            
            return conn;
        } catch(SQLException e){
            System.out.println("Error de conexión local " + e);
        }
            
        return null;
        
    }
}
