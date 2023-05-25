package modelo.usuario;

import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ortiz
 */
public class Usuario_DAOImp_Eliminar implements usuarioDAO_Eliminar {

    @Override
    public boolean eliminar(int idUsuario) {
        boolean respuesta = false;
        Connection con = Conexion.Conexion();
        try {
            java.sql.PreparedStatement consulta = con.prepareStatement(
                    "delete from tb_usuarios where idUsuario ='" + idUsuario + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e);
        }
        return respuesta;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        com.mysql.jdbc.Connection con = (com.mysql.jdbc.Connection) Conexion.Conexion();
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from tb_usuarios";
        Statement st;
        try {
            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setEstado(rs.getInt("estado"));

                usuarios.add(usuario);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener los usuarios: " + e);
        }
        return usuarios;

    }
}
