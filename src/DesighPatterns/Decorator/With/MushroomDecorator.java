package DesighPatterns.Decorator.With;

public class MushroomDecorator extends PizzaDecorator {

    public MushroomDecorator(BasicPizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + "Mushroom";
    }

    @Override
    public int getCost() {
        return decoratedPizza.getCost() + 20;
    }
}
