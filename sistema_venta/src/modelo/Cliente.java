package modelo;

/**
 *
 * @author Guicho
 */
public class Cliente {

    //Atributos de la clase
    private int idCliente;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String direccion;
    private int estado;

    //Método constructor vacío
    public Cliente() {
        this.idCliente = 0;
        this.nombre = "";
        this.apellido = "";
        this.cedula = "";
        this.telefono = "";
        this.direccion = "";
        this.estado = 0;
    }

    //Método constructor sobrecargado
    public Cliente(int idCliente, String nombre, String apellido, String ine, String telefono, String direccion, int estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = ine;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    //Getters and Seters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String ine) {
        this.cedula = ine;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
