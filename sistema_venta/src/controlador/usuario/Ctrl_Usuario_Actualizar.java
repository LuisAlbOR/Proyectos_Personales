package controlador.usuario;

import java.util.List;
import modelo.usuario.Usuario;
import modelo.usuario.UsuarioDAO_Actualizar;

/**
 *
 * @author ortiz
 */
public class Ctrl_Usuario_Actualizar {
    
    private final UsuarioDAO_Actualizar usuarioDAO_Visualizar;
    
    public  Ctrl_Usuario_Actualizar(UsuarioDAO_Actualizar usuarioDAO_Visualizar){
        this.usuarioDAO_Visualizar = usuarioDAO_Visualizar;
    }
    
    public Usuario obtenerDatosUsuario(int idUsuario){
        return usuarioDAO_Visualizar.obtenerDatosUsuario(idUsuario);
    }
    
    public List<Usuario> obtenerUsuarios(){
        return usuarioDAO_Visualizar.obtenerUsuarios();
    }
    
    public boolean actualizar(Usuario objeto, int idUsuario){
        return usuarioDAO_Visualizar.actualizar(objeto, idUsuario);
    }
}
