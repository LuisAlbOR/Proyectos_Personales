package controlador.usuario;

import modelo.usuario.Usuario;
import modelo.usuario.usuarioDAO_Nuevo;

/**
 *
 * @author Guicho
 */
public class Ctrl_Usuario_Nuevo {

    private final usuarioDAO_Nuevo usuarioDAO_Nuevo;

    public Ctrl_Usuario_Nuevo(usuarioDAO_Nuevo usuarioDAO_Nuevo) {
        this.usuarioDAO_Nuevo = usuarioDAO_Nuevo;
    }

    //método para guardar un nuevo usuario
    public boolean guardar(Usuario usuario) {
        return this.usuarioDAO_Nuevo.guardar(usuario);
    }

    //método para confirmar si el cliente ya existe
    public boolean existeUsuario(String usuario) {
        return usuarioDAO_Nuevo.existeUsuario(usuario);
    }
}
