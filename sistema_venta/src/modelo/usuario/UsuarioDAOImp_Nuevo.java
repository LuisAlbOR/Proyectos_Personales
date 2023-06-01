package modelo.usuario;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guicho
 */
public class UsuarioDAOImp_Nuevo implements usuarioDAO_Nuevo {

    @Override
    public boolean existeUsuario(String usuario) {
        boolean respuest = false;

        String sql = "select usuario from tb_usuarios where usuario = '" + usuario + "'";
        Statement st;

        Connection con = conexion.Conexion.Conexion();

        try {

            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuest = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario " + e);
        }

        return respuest;
    }

    @Override
    public boolean guardar(Usuario usuario) {
        boolean respuesta = false;

        try (Connection con = conexion.Conexion.Conexion()) {
            String sql = "INSERT INTO tb_usuarios (nombre, apellido, usuario, password, telefono, estado) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement consulta = (PreparedStatement) con.prepareStatement(sql)) {
                consulta.setString(1, usuario.getNombre());
                consulta.setString(2, usuario.getApellido());
                consulta.setString(3, usuario.getUsuario());
                consulta.setString(4, usuario.getPassword());
                consulta.setString(5, usuario.getTelefono());
                consulta.setInt(6, usuario.getEstado());

                respuesta = consulta.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario: " + e);
        }

        return respuesta;
    }
}
