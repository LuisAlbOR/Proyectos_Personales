package controlador;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.InterFacturacion;
//import com.sun.tools.javac.code.
/**
 *
 * @author Guicho
 */
public class Venta_PDF {

    private String nombreCliente = "";
    private String cedulaCliente = "";
    private String telefonoCliente = "";
    private String direccionCliente = "";
    private String fechaActual = "";
    private String nombreArchivoPdfVenta = "";

    //Método    obtener datos del cliente
    public void datosCliente(int idCliente){
        Connection con = (Connection) conexion.Conexion. Conexion();
        String sql = "select * from tb_cliente where idCliente = '"+idCliente+"'";
        Statement st;
        
        try {
            
            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                cedulaCliente = rs.getString("cedula");
                telefonoCliente = rs.getString("telefono");
                direccionCliente = rs.getString("direccion");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del cliente " + e);
        }
    }
    
    //Método para generar factura de venta
    public void generarFacturaPdf(){
        
        try {
            //Cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("YYYY/MM/DD").format(date);
            //cambiar el formato de la fecha '/' A '_'
            String fechaNueva = "";
            
            for(int i = 0; i < fechaActual.length(); i++){
                if(fechaActual.charAt(i) == '/'){
                    fechaNueva = fechaActual.replace("/","_");
                }
            } 
            
            nombreArchivoPdfVenta = "Venta_"+nombreCliente+"_"+fechaNueva+".pdf";
            
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPdfVenta);
            archivo = new FileOutputStream(file);
            
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            
            Image img = Image.getInstance("src/img/ventas.png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE );//Agregar nueva linea
            fecha.add("Factura: 001" + "\nFecha: "+ fechaActual + "\n\n");
            
            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);//Quitar borde de la tabla
            //Tamaño de las celdas
            float[] columnaEncabezado = new float[] {20f,30f,70f,40f};
            encabezado.setWidths(columnaEncabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //Agregar celdas
            encabezado.addCell(img);
            String ruc = "0987654321";
            String nombre = "Universida Aútonoma de Chiapas";
            String telefono = "962-000-00-00";
            String direccion = "Los naranjos";
            String razon = "Facultad de Negocios, Campus IV";
            
            encabezado.addCell("");//Celda vacía
            encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nEAZON SOCIAL: " + razon);
            encabezado.addCell(fecha);
            
            doc.add(encabezado);
            
            //CUERPO
            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);//NUEVA LINEA
            cliente.add("Datos del cliente" + "\n\n");
            doc.add(cliente);
            
            //DATOS DEL CLIENTE
            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);//Quitar bordes
            //Tamaño de las celdas
            float[] columnaCliente = new float[] {25f,35f,20f,20f};
            tablaCliente.setWidths(columnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell clienteInfoUno = new PdfPCell(new Phrase("Cedula/RUC: ", negrita));
            PdfPCell clienteInfoDos = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell clienteInfoTres = new PdfPCell(new Phrase("Teléfono: ", negrita));
            PdfPCell clienteInfoCuatro = new PdfPCell(new Phrase("Dirección: ", negrita));
            //Quitar bordes
            clienteInfoUno.setBorder(0);
            clienteInfoDos.setBorder(0);
            clienteInfoTres.setBorder(0);
            clienteInfoCuatro.setBorder(0);
            //Agregar celda a la tabla
            tablaCliente.addCell(clienteInfoUno);
            tablaCliente.addCell(clienteInfoDos);
            tablaCliente.addCell(clienteInfoTres);
            tablaCliente.addCell(clienteInfoCuatro);
            tablaCliente.addCell(cedulaCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            tablaCliente.addCell(direccionCliente);
            //Agregar al documento
            doc.add(tablaCliente);
            
            //Espacio en blanco
            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);
            
            //Agregar los productos
            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);
            //Tamñano de celda
            float[] columnaProducto = new float[] {15f,50f,15f,20f};
            tablaProducto.setWidths(columnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell productoUno = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell productoDos = new PdfPCell(new Phrase("Descripción: ", negrita));
            PdfPCell productoTres = new PdfPCell(new Phrase("Precio unitario: ", negrita));
            PdfPCell productoCuatro = new PdfPCell(new Phrase("Precio total: ", negrita));
            //Quitar los bordes
            productoUno.setBorder(0);
            productoDos.setBorder(0);
            productoTres.setBorder(0);
            productoCuatro.setBorder(0);
            //Agregar color al encabezado
            productoUno.setBackgroundColor(BaseColor.LIGHT_GRAY);
            productoDos.setBackgroundColor(BaseColor.LIGHT_GRAY);
            productoTres.setBackgroundColor(BaseColor.LIGHT_GRAY);
            productoCuatro.setBackgroundColor(BaseColor.LIGHT_GRAY);
            //Agregar celdas a la tabla
            tablaProducto.addCell(productoUno);
            tablaProducto.addCell(productoDos);
            tablaProducto.addCell(productoTres);
            tablaProducto.addCell(productoCuatro);
            
            for(int i = 0 ; i < InterFacturacion.jTable_producto.getRowCount(); i++){
                String producto = InterFacturacion.jTable_producto.getValueAt(i, 1).toString();
                String cantidad = InterFacturacion.jTable_producto.getValueAt(i, 2).toString();
                String precio = InterFacturacion.jTable_producto.getValueAt(i, 3).toString();
                String total = InterFacturacion.jTable_producto.getValueAt(i, 7).toString();
            
                //Agregando las celdas a la tabla
                tablaProducto.addCell(producto);
                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }
            //Agregar al documento
            doc.add(tablaProducto);
            
            //Agregar total a pagar
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a pagar: " + InterFacturacion.txt_total_a_pagar.getText().trim());
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            //Firma
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelación y firma\n\n");
            firma.add("__________________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            //Mensaje de: Gracias por su compra
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por su compra!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            
            //Cerrar el documento y el archivo
            doc.close();
            archivo.close();
            
            //Abrir el documento en el navegador al ser generado
            Desktop.getDesktop().open(file);
            
        } catch (DocumentException | IOException e) {
            System.out.println("Error en los puntos: " + e);
        }
    }
}
