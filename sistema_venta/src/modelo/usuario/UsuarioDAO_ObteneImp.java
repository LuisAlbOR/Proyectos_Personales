package modelo.usuario;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Guicho
 */
public class UsuarioDAO_ObteneImp implements usuarioDAO_ObtenerUsuarios {

    @Override
    public List<Usuario> obtenerUsuarios() {
        Connection con = (Connection) Conexion.Conexion();
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
