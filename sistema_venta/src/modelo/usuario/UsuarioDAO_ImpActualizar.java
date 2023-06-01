package modelo.usuario;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conexion.Conexion;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ortiz
 */
public class UsuarioDAO_ImpActualizar implements UsuarioDAO_Actualizar {

    @Override
    public Usuario obtenerDatosUsuario(int idUsuario) {
        Usuario usuario = null;
        try ( Connection con = (Connection) Conexion.Conexion()) {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("select * from tb_usuarios where idUsuario = ?");
            pst.setInt(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuario.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException ex) {
            System.out.println("Error en el modelo " + ex);
        }
        return usuario;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try ( Connection con = (Connection) Conexion.Conexion()) {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("SELECT * FROM tb_usuarios");
            ResultSet rs = pst.executeQuery();
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
        } catch (SQLException e) {
            System.out.println("Error al obtener los usuarios de la base de datos: " + e);
        }
        return usuarios;
    }

    @Override
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        java.sql.Connection con = Conexion.Conexion();
        try {

            java.sql.PreparedStatement consulta = con.prepareStatement("update tb_usuarios set nombre=?, apellido = ?, usuario = ?, password= ?, telefono = ?, estado = ? where idUsuario ='" + idUsuario + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getUsuario());
            consulta.setString(4, objeto.getPassword());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e);
        }
        return respuesta;
    }
}
