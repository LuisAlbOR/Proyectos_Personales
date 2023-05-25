package controlador;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cliente;

/**
 *
 * @author Guicho
 */
public class Ctrl_Cliente {

    //método para guardar un nuevo cliente
    public boolean guardar(Cliente objeto) {

        boolean respuest = false;

        Connection con = conexion.Conexion.Conexion();

        try {
            PreparedStatement consulta = (PreparedStatement) con.prepareStatement("insert into tb_cliente values(?,?,?,?,?,?,?)");

            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getCedula());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuest = true;
            }

            con.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente " + e);
        }

        return respuest;
    }

    //método para confirmar si el cliente ya existe
    public boolean existeCliente(String cedula) {

        boolean respuest = false;

        String sql = "select cedula from tb_cliente where cedula = '" + cedula + "'";
        Statement st;

        Connection con = conexion.Conexion.Conexion();

        try {
            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                respuest = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar cliente " + e);
        }

        return respuest;
    }

    //Método para actualizar un cliente en la BD
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection con = Conexion.Conexion();
        try {

            java.sql.PreparedStatement consulta = con.prepareStatement("update tb_cliente set nombre=?, apellido = ?, cedula = ?, telefono= ?, direccion = ?, estado = ? where idCliente ='" + idCliente + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getCedula());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e);
        }
        return respuesta;
    }

    //Método para eliminar un cliente de la BD
    public boolean eliminar(int idCliente) {
        boolean respuesta = false;
        Connection con = Conexion.Conexion();
        try {
            java.sql.PreparedStatement consulta = con.prepareStatement(
                    "delete from tb_cliente where idCliente ='" + idCliente + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e);
        }
        return respuesta;
    }
}
