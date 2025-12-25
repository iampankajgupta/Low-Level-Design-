package DesighPatterns.Decorator.Without;

public class CheesePizza extends Pizza{


    public String getDescription() {
        return super.getDescription() + "Cheese ";
    }

    public int getCost() {
        return super.getCost() + 10;
    }
}
