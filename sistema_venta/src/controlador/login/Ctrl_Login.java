package controlador.login;

import modelo.usuario.Usuario;
import modelo.login.LoginDAO;

/**
 *
 * @author Guicho
 */
public class Ctrl_Login {
    
    private final LoginDAO loginDAO;
    
    public Ctrl_Login(LoginDAO loginDAO){
        this.loginDAO = loginDAO;
    }
    
    public boolean Login(Usuario objeto){
    return loginDAO.loginUser(objeto);
    }
}
