package modelo.producto;

import java.util.List;

/**
 *
 * @author ortiz
 */
public interface ProductoDAO_Visualizar {
    List<Producto> obtenerProducto();
    String obtenerNombreCategoria(int idCategoria);
}
