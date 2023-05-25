package modelo.producto;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ortiz
 */
public class ProductoDAO_ImpVisualizar implements ProductoDAO_Visualizar {

    @Override
    public List<Producto> obtenerProducto() {
        Connection con = Conexion.Conexion();
        List<Producto> productos = new ArrayList<>();
        String sql = "select p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, p.estado, p.idCategoria from tb_producto As p;";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCantidad(rs.getInt("cantidad"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPorcentajeIva(rs.getInt("porcentajeIva"));
                producto.setEstado(rs.getInt("estado"));
                producto.setIdCategoria(rs.getInt("idCategoria"));
                productos.add(producto);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos de la tabla productos: " + e);
        }

        return productos;
    }

    @Override
    public String obtenerNombreCategoria(int idCategoria) {
        String nombreCategoria = "";
        Connection con = Conexion.Conexion();
        String sql = "select * from tb_categoria where idCategoria = " + idCategoria + ";";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                nombreCategoria = rs.getString("descripcion");
                System.out.println("Se ejecuto al consulta");
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener nombre de la categoria " + e);
        }

        return nombreCategoria;
    }

}
