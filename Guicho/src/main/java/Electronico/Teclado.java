package Electronico;

public class Teclado implements ITeclado {
   @Override
    public void Conectar() {
        System.out.println("Conexión del teclado vía USB");
    }
}
