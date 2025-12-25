package DesighPatterns.Decorator.Without;

public class Client {
    public static void main(String[] args) {
        Pizza pizza = new MushroomPizza();
        System.out.println(pizza.getDescription());
        System.out.println(pizza.getCost());
    }
}
