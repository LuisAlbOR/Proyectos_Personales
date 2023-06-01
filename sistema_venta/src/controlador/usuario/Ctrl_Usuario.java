package controlador.usuario;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.usuario.Usuario;

/**
 *
 * @author Guicho
 */
public class Ctrl_Usuario {



    /*
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection con = Conexion.Conexion();
        String sql = "select usuario,password from tb_usuarios where usuario='" + objeto.getUsuario() + "' and password='" + objeto.getPassword() + "'";
        Statement st;

        try {

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("Consulta SQL ejecutada correctamente");
            if (!rs.next()) {
                System.out.println("No se encontraron resultados para la consulta SQL");
            }
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }

        return respuesta;

    }*/
    //método para guardar un nuevo usuario
  //  public boolean guardar(Usuario usuario, UsuarioDAO usuarioDAO){
   //     return this.usuarioDAO.guardar(usuario, usuarioDAO);
  //  }
    /*
    public boolean guardar(Usuario objeto) {

        boolean respuest = false;

        Connection con = conexion.Conexion.Conexion();

        try {
            com.mysql.jdbc.PreparedStatement consulta = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("insert into tb_usuarios values(?,?,?,?,?,?,?)");

            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getUsuario());
            consulta.setString(5, objeto.getPassword());
            consulta.setString(6, objeto.getTelefono());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuest = true;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar usuario " + e);
        }

        return respuest;
    }
    */
    //método para confirmar si el cliente ya existe
   // public boolean existeUsuario(String usuario){
     //   return usuarioDAO.existeUsuario(usuario);
   // }
    /*
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
    */
    //Método para actualizar un usuario en la BD
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        Connection con = Conexion.Conexion();
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

    //Método para eliminar un usuario de la BD
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

    /*
    public boolean loginUser(Usuario objeto) {

        boolean respuesta = false;

        Connection con = Conexion.Conexion();

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("select usuario, password from tb_usuarios where usuario= ? and password = ?");
            ps.setString(1, objeto.getUsuario());
            ps.setString(2, objeto.getPassword());
            ResultSet rs = ps.executeQuery();
            

            while (rs.next()) {
                respuesta = true;
            }
            System.out.println("Consulta SQL ejecutada correctamente");
            if (!respuesta) {
                System.out.println("No se encontraron resultados para la consulta SQL");
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión");
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        }

        return respuesta;
    }
    */
}
