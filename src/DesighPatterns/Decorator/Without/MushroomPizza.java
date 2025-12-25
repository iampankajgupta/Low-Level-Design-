package DesighPatterns.Decorator.Without;

public class MushroomPizza extends CheesePizza{
    public String getDescription() {
        return super.getDescription() + "Mushroom";
    }

    public int getCost() {
        return super.getCost() + 20;
    }
}
