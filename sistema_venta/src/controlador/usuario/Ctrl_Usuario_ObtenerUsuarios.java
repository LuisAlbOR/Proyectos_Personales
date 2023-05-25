
package controlador.usuario;

import java.util.List;
import modelo.usuario.Usuario;
import modelo.usuario.usuarioDAO_ObtenerUsuarios;

/**
 *
 * @author Guicho
 */
public class Ctrl_Usuario_ObtenerUsuarios {
    private final usuarioDAO_ObtenerUsuarios usuarioDAO_ObtUsuario;
    
    public Ctrl_Usuario_ObtenerUsuarios(usuarioDAO_ObtenerUsuarios usuarioDAO_ObtUsuario){
        this.usuarioDAO_ObtUsuario = usuarioDAO_ObtUsuario;
    }

    public List<Usuario> obtenerUsuarios(){
        return usuarioDAO_ObtUsuario.obtenerUsuarios();
    }

}
