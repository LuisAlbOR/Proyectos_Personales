package controlador.usuario;

import java.util.List;
import modelo.usuario.Usuario;
import modelo.usuario.usuarioDAO_Eliminar;

/**
 *
 * @author Guicho
 */
public class Ctrl_Usuario_Eliminar {
    private final usuarioDAO_Eliminar usuarioDAO_Eliminar;
    
    public Ctrl_Usuario_Eliminar( usuarioDAO_Eliminar usuarioDAO_Eliminar){
        this.usuarioDAO_Eliminar = usuarioDAO_Eliminar;
    }

    public boolean eliminar(int idUsuario){
        return usuarioDAO_Eliminar.eliminar(idUsuario);
    }
    
        public List<Usuario> obtenerUsuarios(){
        return usuarioDAO_Eliminar.obtenerUsuarios();
    }
}
