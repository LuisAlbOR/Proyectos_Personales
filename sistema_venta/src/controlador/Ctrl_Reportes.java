package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Guicho
 */
public class Ctrl_Reportes {

    //Método para crear reportes de los clientes registrados en el sistema
    public void reportesClientes() {

        Document doc = new Document();

        try {
            String ruta = System.getProperty("user.home") + "\\Desktop";
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "\\Reportes_Clientes.pdf"));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            //Formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nGuichoMaster ©Guicho_Master\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de cliente \n\n");

            doc.open();
            //Agregamos los datos
            doc.add(header);
            doc.add(parrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Código");
            tabla.addCell("Nombres");
            tabla.addCell("Cedula");
            tabla.addCell("Teléfono");
            tabla.addCell("Dirección");

            try {
                Connection con = (Connection) conexion.Conexion.Conexion();
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(""
                        + "select idCliente, concat(nombre, ' ' , apellido) as nombre, cedula, telefono, direccion from tb_cliente");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());

                    doc.add(tabla);

                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }

            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }
    
    //Método para crear reportes de los productos registrados en el sistema
    public void reportesProductos() {

        Document doc = new Document();

        try {
            String ruta = System.getProperty("user.home") + "\\Desktop";
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "\\Reportes_Productos.pdf"));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            //Formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nGuichoMaster ©Guicho_Master\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de producto \n\n");

            doc.open();
            //Agregamos los datos
            doc.add(header);
            doc.add(parrafo);

            float[] columnsWith = {3,5,4,5,7,5,6};
            PdfPTable tabla = new PdfPTable(columnsWith);
            tabla.addCell("Código");
            tabla.addCell("Nombres");
            tabla.addCell("Cant.");
            tabla.addCell("Precio");
            tabla.addCell("Descripción");
            tabla.addCell("%Iva");
            tabla.addCell("Categoria");

            try {
                Connection con = (Connection) conexion.Conexion.Conexion();
                PreparedStatement pst = (PreparedStatement) con.prepareStatement("select p.idProducto, p.nombre, p.cantidad, p.precio,"
                        + " p.descripcion, p.porcentajeIVa, c.descripcion as categoria, p.estado\n" 
                +" from tb_producto as p , tb_categoria as c\n" 
                +" where p.idCategoria = c.idCategoria");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());

                    doc.add(tabla);

                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }

            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }
    
    //Método para crear reportes de los categorias registrados en el sistema
    public void reportesCategorias() {

        Document doc = new Document();

        try {
            String ruta = System.getProperty("user.home") + "\\Desktop";
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "\\Reportes_Categorias.pdf"));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            //Formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nGuichoMaster ©Guicho_Master\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de categorias \n\n");

            doc.open();
            //Agregamos los datos
            doc.add(header);
            doc.add(parrafo);

            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Código");
            tabla.addCell("Descripcion");
            tabla.addCell("Estado");

            try {
                Connection con = (Connection) conexion.Conexion.Conexion();
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(""
                        + "select * from tb_categoria");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                    } while (rs.next());

                    doc.add(tabla);

                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }

            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }

    //Método para crear reportes de los ventas registrados en el sistema
    public void reportesVentas() {

        Document doc = new Document();

        try {
            String ruta = System.getProperty("user.home") + "\\Desktop";
            PdfWriter.getInstance(doc, new FileOutputStream(ruta + "\\Reportes_Ventas.pdf"));
            Image header = Image.getInstance("src/img/header1.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            //Formato al texto
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte creado por \nGuichoMaster ©Guicho_Master\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de ventas \n\n");

            doc.open();
            //Agregamos los datos
            doc.add(header);
            doc.add(parrafo);

            float[] columnsWith = {3,9,4,5,3};
            PdfPTable tabla = new PdfPTable(columnsWith);
            tabla.addCell("Código");
            tabla.addCell("Cliente");
            tabla.addCell("T. Pagar.");
            tabla.addCell("F. Venta");
            tabla.addCell("Estado");

            try {
                Connection con = (Connection) conexion.Conexion.Conexion();
                PreparedStatement pst = (PreparedStatement) con.prepareStatement(" select cv.idCabeceraVenta as id, concat(c.nombre, ' ' , c.apellido) as cliente,"
                        + " cv.valorPagar as total, cv.fechaVenta as venta, cv.estado"
                        + " from tb_cabecera_venta as cv,  tb_cliente as c"
                        + " where cv.idCliente =  c.idCliente;");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());

                    doc.add(tabla);

                }

            } catch (SQLException e) {
                System.out.println("Error 4 en: " + e);
            }

            doc.close();
            JOptionPane.showMessageDialog(null, "Reporte creado");
            
        } catch (DocumentException e) {
            System.out.println("Error 1 en: " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("Error 2 en: " + ex);
        } catch (IOException ex) {
            System.out.println("Error 3 en: " + ex);
        }
    }
}
