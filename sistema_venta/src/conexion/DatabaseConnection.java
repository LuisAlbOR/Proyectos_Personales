package conexion;

import java.sql.Statement;

/*
    autor Guicho
*/

public interface DatabaseConnection {

    void connect();

    void disconnect();

    Statement createStatement();
    
}
