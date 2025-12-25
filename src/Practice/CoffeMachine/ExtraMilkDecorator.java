package Practice.CoffeMachine;

public class ExtraMilkDecorator extends DrinkDecorator{

    public ExtraMilkDecorator(Drink baseDrink) {
        super(baseDrink);
    }

    @Override
    protected void addIngredients() {
        super.addIngredients();
        System.out.println("Adding Extra Milk!!!");
    }

}
