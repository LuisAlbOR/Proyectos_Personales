package modelo.usuario;

import java.util.List;

/**
 *
 * @author Guicho
 */
public interface usuarioDAO_Eliminar{
    public boolean eliminar(int idUsuario);
    List<Usuario> obtenerUsuarios();
}
