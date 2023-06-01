package modelo.producto;

import java.util.List;

/**
 *
 * @author ortiz
 */
public interface ProductoDAO_Nuevo {
    List<String> obtenerCategorias();
    public boolean existeProducto(String producto);
    int idCategoria(String descripcion);
    public boolean guardar(Producto objeto);
}
