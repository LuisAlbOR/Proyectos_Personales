package modelo.producto;

import com.mysql.jdbc.PreparedStatement;
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
public class ProductoDAO_ImpNuevo implements ProductoDAO_Nuevo{

    @Override
    public List<String> obtenerCategorias() {
        java.sql.Connection con = conexion.Conexion.Conexion();
        String sql = "select * from  tb_categoria";
        Statement st;
        List<String> categorias = new ArrayList<>();
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            
            while (rs.next()) {
                categorias.add(rs.getString("descripcion"));
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al categorias " + e);
        }
        
        return categorias;
    }

     
    @Override
    public boolean existeProducto(String producto) {

        boolean respuest = false;

        String sql = "select nombre from tb_producto where nombre = '" + producto + "'";
        Connection con = conexion.Conexion.Conexion();
        com.mysql.jdbc.Statement st;
        
        try {
            
            st = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuest = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar producto " + e);
        }

        return respuest;
    
    }

    @Override
    public int idCategoria(String descripcion) {
        Connection con = conexion.Conexion.Conexion();
        String sql = "select * from tb_categoria where descripcion = '" + descripcion + "'";
        Statement st;
        int obtenerIdCategoria = 0;
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                obtenerIdCategoria = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener id de la categoria " + e);
        }
        return obtenerIdCategoria;
    }
    
    @Override
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
}
