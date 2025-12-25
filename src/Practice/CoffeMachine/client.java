package Practice.CoffeMachine;

import Practice.DecoratorOption;
import Practice.Ingredient.IngredientStore;

public class client {
    public static void main(String[] args) {
        // Coffee Machine
        // Coffee Machine -> accepts drink, prepare drink, deduct ingredient
        // Coffee <abstract class> name, cost, ingredients
        // Coffee factory, will take cofferType and ingredients
        // Coffee types <>
        // Ingredient -> name, quantity

        // Code is not as production level
        /*
        IngredientStore ingredientStore = new IngredientStore(50, 50,50);
        CoffeeMachine coffeeMachine = new CoffeeMachine(ingredientStore);

        Drink drink = DrinkFactory.createDrink(DrinkType.LATTE);
        drink = new ExtraSugar(drink);
        drink = new ExtraMilkDecorator(drink);

        coffeeMachine.setCoffeeMachineState(new IdleState());
        coffeeMachine.getCoffeeMachineState().idle(coffeeMachine);
        coffeeMachine.getCoffeeMachineState().makeDrink(coffeeMachine, drink);

         */

        IngredientStore ingredientStore = new IngredientStore(50, 50,50);
        CoffeeMachine coffeeMachine = new CoffeeMachine(ingredientStore);
        DrinkRequest request = new DrinkRequest.Builder().setType(DrinkType.LATTE)
                .addOptions(DecoratorOption.EXTRA_MILK).build();
       coffeeMachine.orderDrink(request);


    }
}
