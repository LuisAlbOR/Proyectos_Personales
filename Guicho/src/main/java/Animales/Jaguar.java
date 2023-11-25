package Animales;

public class Jaguar extends Animal implements IFelinoSalvaje{
    @Override
    public void Rugir() {
        System.out.println("EL jaguar Ruge");
    }
    @Override
    public void Cazar(){
        System.out.println("El jaguar Cazar");
    }
}
