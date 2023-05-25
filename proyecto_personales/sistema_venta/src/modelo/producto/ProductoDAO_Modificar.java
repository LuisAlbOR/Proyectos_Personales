package modelo.producto;

import java.util.List;

/**
 *
 * @author ortiz
 */
public interface ProductoDAO_Modificar {

    List<Producto> obtenerProducto();

    String obtenerNombreCategoria(int idCategoria);
}
