package controlador.producto;

import java.util.List;
import modelo.producto.Producto;
import modelo.producto.ProductoDAO_Modificar;

/**
 *
 * @author ortiz
 */
public class Ctrl_Producto_Modificar {
    private final ProductoDAO_Modificar productoDAO_Modificar;

    public Ctrl_Producto_Modificar(ProductoDAO_Modificar productoDAO_Modificar) {
        this.productoDAO_Modificar = productoDAO_Modificar;
    }
    
    public List<Producto> obtenerProductos(){
        return productoDAO_Modificar.obtenerProducto();
    }
    
    public String obtenerNombreCategoria(int idCategoria){
        return productoDAO_Modificar.obtenerNombreCategoria(idCategoria);
    }
}
