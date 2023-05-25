package controlador.producto;

import java.util.List;
import modelo.producto.Producto;
import modelo.producto.ProductoDAO_Visualizar;

/**
 *
 * @author ortiz
 */
public class Ctrl_Producto_Visualizar {
    private final ProductoDAO_Visualizar productoDAO_Visualizar;

    public Ctrl_Producto_Visualizar(ProductoDAO_Visualizar productoDAO_Visualizar) {
        this.productoDAO_Visualizar = productoDAO_Visualizar;
    }
    
    public List<Producto> obtenerProductos(){
        return productoDAO_Visualizar.obtenerProducto();
    }
    
    public String obtenerNombreCategoria(int idCategoria){
        return productoDAO_Visualizar.obtenerNombreCategoria(idCategoria);
    }
}
