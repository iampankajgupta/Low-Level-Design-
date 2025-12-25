package Practice.CoffeMachine;

import Practice.CoffeMachine.Factory.DrinkFactory;
import Practice.CoffeMachine.State.CoffeeMachineState;
import Practice.CoffeMachine.State.IdleState;
import Practice.Ingredient.IngredientStore;

public class CoffeeMachine {

    private IngredientStore ingredientStore;
    private CoffeeMachineState coffeeMachineState;

    public void setCoffeeMachineState(CoffeeMachineState coffeeMachineState) {
        this.coffeeMachineState = coffeeMachineState;
    }

    public CoffeeMachineState getCoffeeMachineState() {
        return coffeeMachineState;
    }

    public IngredientStore getIngredientStore() {
        return ingredientStore;
    }

    public void setIngredientStore(IngredientStore ingredientStore) {
        this.ingredientStore = ingredientStore;
    }

    public CoffeeMachine(IngredientStore ingredientStore) {
        this.ingredientStore = ingredientStore;
        coffeeMachineState = new IdleState();
    }

    // not need for synchronised if only one machine process at a time then make this method synchronised
    public void orderDrink(DrinkRequest request) {
        if(request != null && request.getType() != null) {
            Drink drink = DrinkFactory.createDrink(request.getType());
            // set the decorator
            drink = DecoratorRegistry.applyOptions(drink, request.getDecoratorList());
            // this is not required as initial state of coffeeMachine is idle state only
            // CoffeeMachineState coffeeMachineState1 = new IdleState();
             coffeeMachineState.makeDrink(this, drink);
        }else {
            System.out.println("Please select the drink");
        }
    }

    /*
    public Drink makeDrink(Drink drink) {
        System.out.println("Call on make drink....");
        // get the Drink
        if(ingredientStore.hasEnoughIngredients(drink)) {
            System.out.println("Making Drink of type :"+ drink);
            ingredientStore.consumeIngredients(drink);
            drink.prepare();
            return drink;
        }
        throw new IllegalArgumentException("Ingredients are not sufficient!");
    }

     */
}
