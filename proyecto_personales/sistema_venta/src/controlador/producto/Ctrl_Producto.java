package controlador.producto;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.producto.Producto;

/**
 *
 * @author Guicho - ©Todos los derechos reservados
 */
public class Ctrl_Producto {

    //método para guardar un nuevo producto
    public boolean guardar(Producto objeto) {

        boolean respuest = false;

        Connection con = conexion.Conexion.Conexion();

        try {
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("insert into tb_producto(nombre,cantidad,precio,descripcion,porcentajeIva,idCategoria,estado) values(?,?,?,?,?,?,?)");
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3, objeto.getPrecio());
            consulta.setString(4, objeto.getDescripcion());
            consulta.setInt(5, objeto.getPorcentajeIva());
            consulta.setInt(6, objeto.getIdCategoria());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuest = true;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar producto " + e);
        }

        return respuest;
    }

    //método para confirmar si el producto ya existe
    public boolean existeProducto(String producto) {

        boolean respuest = false;

        String sql = "select nombre from tb_producto where nombre = '" + producto + "'";
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
            System.out.println("Error al consultar producto " + e);
        }

        return respuest;
    }

    //Método para actualizar un producto en la BD
    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Connection con = Conexion.Conexion();
        try {

            java.sql.PreparedStatement consulta = con.prepareStatement("update tb_producto set nombre=?, cantidad = ?, precio = ?, descripcion= ?, porcentajeIva = ?, idCategoria = ?, estado = ? where idProducto ='" + idProducto + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3, objeto.getPrecio());
            consulta.setString(4, objeto.getDescripcion());
            consulta.setInt(5, objeto.getPorcentajeIva());
            consulta.setInt(6, objeto.getIdCategoria());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }
        return respuesta;
    }

    //Método para eliminar un producto de la BD
    public boolean eliminar(int idProducto) {
        boolean respuesta = false;
        Connection con = Conexion.Conexion();
        try {
            java.sql.PreparedStatement consulta = con.prepareStatement(
                    "delete from tb_producto where idProducto ='" + idProducto + "'");
            

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
        }
        return respuesta;
    }

    //Método actualizar stock
    public boolean actualizarStock(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Connection con = conexion.Conexion.Conexion();

        try {
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("update tb_producto set cantidad=? where idProducto = '" + idProducto + "'");
            pst.setInt(1, objeto.getCantidad());

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }

        return respuesta;
    }
}
