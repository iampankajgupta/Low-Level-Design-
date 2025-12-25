package Practice.CoffeMachine.State;

import Practice.CoffeMachine.CoffeeMachine;
import Practice.CoffeMachine.Drink;

public class IdleState implements CoffeeMachineState{

    @Override
    public void idle(CoffeeMachine coffeeMachine) {
        System.out.println("Machine is already in idle state.");
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine, Drink drink) {
        /*
        if(!coffeeMachine.getIngredientStore().hasEnoughIngredients(drink)) {
            System.out.println("Not Enough Ingredients..");
            coffeeMachine.setCoffeeMachineState(new OutOfIngredientState());
            // Below line is wrong because we state cannot change state and call its method
            // coffeeMachine.getCoffeeMachineState().refill(coffeeMachine);
        }

         */
        if(!coffeeMachine.getIngredientStore().tryConsume(drink)) {
            System.out.println("Not Enough Ingredients..");
            coffeeMachine.setCoffeeMachineState(new OutOfIngredientState());
            return;
        }
        // enough ingredients, now brew
        coffeeMachine.setCoffeeMachineState(new BrewingState());
        coffeeMachine.getCoffeeMachineState().makeDrink(coffeeMachine, drink);
    }
    /*
        Yes — adding this is correct, but with one important improvement.
        Let’s review your method:

        @Override
        public void refill(CoffeeMachine coffeeMachine) {
            System.out.println("Refill the Ingredients....");
            coffeeMachine.getIngredientStore().refillFully();
        }

        ✔️ This is correct because:
        In IdleState, the machine is not brewing anything.
        So refill is allowed.
        Refilling the IngredientStore is the right responsibility.
        ✅ But you MUST also change state after refill
        Right now, even if ingredients were previously empty, the machine will stay in the IdleState.
        This is acceptable, but not optimal, because you also have an OutOfIngredientState.
        Better approach:

        If machine is in OutOfIngredientState → after refill it should go to IdleState
        But in IdleState, refill should not change the state.
        So the ideal behavior:
        IdleState
        Allowed: refill
        Do not change state
     */

    @Override
    public void refill(CoffeeMachine coffeeMachine) {
        System.out.println("Refill the Ingredients....");
     //    coffeeMachine.getIngredientStore().refillFully();
        // which is good and it should stay in idle state only
    }
}
