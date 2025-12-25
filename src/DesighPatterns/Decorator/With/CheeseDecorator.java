package DesighPatterns.Decorator.With;

public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(BasicPizza basePizza) {
        super(basePizza);
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription() + "Cheese";
    }

    @Override
    public int getCost() {
        return decoratedPizza.getCost() + 10;
    }
}
