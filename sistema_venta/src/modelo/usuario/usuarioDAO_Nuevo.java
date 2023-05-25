package modelo.usuario;

/**
 *
 * @author Guicho
 */
public interface usuarioDAO_Nuevo {

    public boolean existeUsuario(String usuario);
    public boolean guardar(Usuario usuario);
}
