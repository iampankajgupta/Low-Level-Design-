package Practice.CoffeMachine.State;

import Practice.CoffeMachine.CoffeeMachine;
import Practice.CoffeMachine.Drink;

public class OutOfIngredientState implements CoffeeMachineState{

    @Override
    public void idle(CoffeeMachine coffeeMachine) {
        System.out.println("System cannot go to idle state");
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine, Drink drink) {
        System.out.println("Unable to prepare the drink due to out of state!!!");
    }

    // changing the state to idle state after refilling
    @Override
    public void refill(CoffeeMachine coffeeMachine) {
        System.out.println("Refilling the state!!");
        // coffeeMachine.getIngredientStore().refillFully();
        coffeeMachine.setCoffeeMachineState(new IdleState());
        System.out.println("Machine Refill Successfully");
    }
}
