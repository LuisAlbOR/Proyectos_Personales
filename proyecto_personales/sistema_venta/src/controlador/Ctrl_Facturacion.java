package controlador;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import modelo.CabeceraVenta;
import java.sql.ResultSet;
import modelo.DetalleVenta;
import modelo.producto.Producto;
/**
 *
 * @author Guicho
 */
public class Ctrl_Facturacion {
    //Último ID de la cabecera
    public static int idCabeceraRegistrada;
    java.math.BigDecimal idColVar;
    
    
    //Método para guardar la cabecera de ventas
    public boolean guardarCabeceraVenta(CabeceraVenta objeto) {

        boolean respuest = false;

        Connection con = conexion.Conexion.Conexion();

        try {
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("insert into tb_cabecera_venta values(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            consulta.setInt(1, 0);
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVeta());
            consulta.setInt(5, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuest = true;
            }

            ResultSet rs = consulta.getGeneratedKeys();
            
            while(rs.next()){
                idColVar = rs.getBigDecimal(1);
                idCabeceraRegistrada = idColVar.intValue();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cabecera de venta " + e);
        }

        return respuest;
    }
    
    //método para guardar el detalle de venta
    public boolean guardarDetalleVenta(DetalleVenta objeto) {

        boolean respuest = false;

        Connection con = conexion.Conexion.Conexion();

        try {
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("insert into tb_detalle_venta values(?,?,?,?,?,?,?,?,?,?)");

            consulta.setInt(1, 0);
            consulta.setInt(2, idCabeceraRegistrada);
            consulta.setInt(3, objeto.getIdProducto());
            consulta.setInt(4, objeto.getCantidad());
            consulta.setDouble(5, objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubTotal());
            consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(8, objeto.getIva());
            consulta.setDouble(9, objeto.getTotalPagar());
            consulta.setInt(10, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuest = true;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar detalle de venta " + e);
        }

        return respuest;
    }
    
    //Método para actualizar una venta en la BD
    public boolean actualizar(CabeceraVenta objeto, int idCabeceraVenta) {
        boolean respuesta = false;
        Connection con = Conexion.Conexion();
        try {

            java.sql.PreparedStatement consulta = con.prepareStatement("update tb_cabecera_venta set idCliente = ?, estado = ? where idCabeceraVenta = '"+idCabeceraVenta+"'");
            consulta.setInt(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cabecera de venta: " + e);
        }
        return respuesta;
    }
}
