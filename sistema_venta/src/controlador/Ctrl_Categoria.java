package controlador;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import modelo.Categoria;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author ortiz
 */
public class Ctrl_Categoria {

    //método para registrar categoria
    public boolean guardar(Categoria objeto) {

        boolean respuest = false;

        Connection con = conexion.Conexion.Conexion();

        try {
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("insert into tb_categoria (idCategoria, descripcion, estado) values (?, ?, ?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuest = true;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar categoria " + e);
        }

        return respuest;
    }

    //método para confirmar categoria
    public boolean existeCategoria(String categoria) {

        boolean respuest = false;

        String sql = "select descripcion from tb_categoria where descripcion = '" + categoria + "'";
        Statement st;

        Connection con = conexion.Conexion.Conexion();

        try {
            Connection connection = conexion.Conexion.Conexion();
            st = (Statement) connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuest = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar categoria " + e);
        }

        return respuest;
    }

    //método para actualizar categoria
    public boolean actualizar(Categoria objeto, int idCategoria) {

        boolean respuest = false;

        Connection con = Conexion.Conexion();

        try {
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("update tb_categoria set descripcion=? where idCategoria ='" + idCategoria + "'");
            consulta.setString(1, objeto.getDescripcion());

            if (consulta.executeUpdate() > 0) {
                respuest = true;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar categoria " + e);
        }

        return respuest;
    }

    //método para eliminar categoria
    public boolean eliminar(int idCategoria) {

        boolean respuest = false;

        Connection con = Conexion.Conexion();

        try {
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement(""
                    + "delete from tb_categoria where idCategoria ='" + idCategoria + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuest = true;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria " + e);
        }

        return respuest;
    }
}
