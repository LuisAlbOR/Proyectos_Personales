package Comida;

public class Pizza {

    private int numeroRebandas;
    private String especialidad;

    public Pizza(int cantidadRenabadas, String especialidad){
        this.numeroRebandas = cantidadRenabadas;
        this.especialidad = especialidad;
    }

    public String toString(){
        return "Cantidad de rebanadas: " + this.numeroRebandas + " Especialidad: " + this.especialidad;
    }
}
