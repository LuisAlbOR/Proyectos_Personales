package Electronico;

public class Mouse implements IMouse {
    @Override
    public void Conectar() {
        System.out.println("Conexión del mouse vía USB");
    }
}
