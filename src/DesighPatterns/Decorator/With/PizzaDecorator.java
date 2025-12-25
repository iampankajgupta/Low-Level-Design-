package DesighPatterns.Decorator.With;

// Pizza Decorator we don't know what to decorate i.e
public abstract class PizzaDecorator implements Pizza{

    protected Pizza decoratedPizza;

    public PizzaDecorator(BasicPizza basePizza) {
        this.decoratedPizza = basePizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public int getCost() {
        return decoratedPizza.getCost();
    }
}
