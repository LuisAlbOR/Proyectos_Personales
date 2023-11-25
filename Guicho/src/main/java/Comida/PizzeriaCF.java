package Comida;

public class PizzeriaCF implements IPizzeria{
    @Override
    public Pizza crearPizza(String tipo) {
        if(tipo.equals("Peperonni"))
            return new Pizza(8,tipo);

        if (tipo.equals("Hawaiana"))
            return new Pizza(8,tipo);

        if(tipo.equals("Peperonni con orilla rellena"))
            return new PizzaOrillaRellena(10, "Peperonni con orilla rellena");

        return null;
    }
}
