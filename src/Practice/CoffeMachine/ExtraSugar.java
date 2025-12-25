package Practice.CoffeMachine;

public class ExtraSugar extends DrinkDecorator {

    public ExtraSugar(Drink baseDrink) {
        super(baseDrink);
    }

    @Override
    protected void addIngredients() {
        super.addIngredients();
        System.out.println("Adding Extra Sugar!!!"); // then decorator-specific step
    }
}
