package modelo;

/**
 *
 * @author Guicho
 */
public class CabeceraVenta {

    //Atributos
    private int idCabeceraVenta;
    private int idCliente;
    private double valorPagar;
    private String fechaVeta;
    private int estado;

    //Método constructor
    public CabeceraVenta() {
        this.idCabeceraVenta = 0;
        this.idCliente = 0;
        this.valorPagar = 0.0;
        this.fechaVeta = "";
        this.estado = 0;
    }

    //Método constructor sobrecargado
    public CabeceraVenta(int idCabeceraVenta, int idCliente, double valorPagar, String fechaVeta, int estado) {
        this.idCabeceraVenta = idCabeceraVenta;
        this.idCliente = idCliente;
        this.valorPagar = valorPagar;
        this.fechaVeta = fechaVeta;
        this.estado = estado;
    }

    //Getters and setters
    public int getIdCabeceraVenta() {
        return idCabeceraVenta;
    }

    public void setIdCabeceraVenta(int idCabeceraVenta) {
        this.idCabeceraVenta = idCabeceraVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public String getFechaVeta() {
        return fechaVeta;
    }

    public void setFechaVeta(String fechaVeta) {
        this.fechaVeta = fechaVeta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    //Método toString
    @Override
    public String toString() {
        return "CabeceraVenta{" + "idCabeceraVenta=" + idCabeceraVenta + ", idCliente=" + idCliente + ", valorPagar=" + valorPagar + ", fechaVeta=" + fechaVeta + ", estado=" + estado + '}';
    }

}
