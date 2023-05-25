package modelo.usuario;

import java.util.List;

/**
 *
 * @author ortiz
 */
public interface UsuarioDAO_Actualizar {

    Usuario obtenerDatosUsuario(int idUsuario);

    public List<Usuario> obtenerUsuarios();
    
    public boolean actualizar(Usuario objeto, int idUsuario);
}
