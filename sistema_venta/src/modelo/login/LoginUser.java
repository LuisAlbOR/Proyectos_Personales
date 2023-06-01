package modelo.login;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conexion.Conexion;
import modelo.usuario.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Guicho
 */
public class LoginUser implements LoginDAO{
    
    @Override
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection con = (Connection) Conexion.Conexion();

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select usuario, password from tb_usuarios where usuario= ? and password = ?");
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getPassword());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al identificar al usuario");        
        }

        return respuesta;    
    }
}
