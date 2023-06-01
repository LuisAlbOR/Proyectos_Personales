package controlador.producto;

import java.util.List;
import modelo.producto.Producto;
import modelo.producto.ProductoDAO_Nuevo;

/**
 *
 * @author ortiz
 */
public class Ctrl_Producto_Nuevo {
    
    private final ProductoDAO_Nuevo productoDAO_Nuevo;
    
    public Ctrl_Producto_Nuevo(ProductoDAO_Nuevo productoDAO_Nuevo) {
        this.productoDAO_Nuevo = productoDAO_Nuevo;
    }
    
    public List<String> obtenerCategoria(){
        return productoDAO_Nuevo.obtenerCategorias();
    }
    
    public boolean existeProducto(String producto){
     return productoDAO_Nuevo.existeProducto(producto);
    }
    
    public int idCategoria(String descripcion){
        return productoDAO_Nuevo.idCategoria(descripcion);
    }
    
    public boolean guardar(Producto objeto){
        return productoDAO_Nuevo.guardar(objeto);
    }
}
