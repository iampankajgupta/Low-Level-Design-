package Practice.CoffeMachine.State;

import Practice.CoffeMachine.CoffeeMachine;
import Practice.CoffeMachine.Drink;

public class BrewingState implements CoffeeMachineState{
    @Override
    public void idle(CoffeeMachine coffeeMachine) {
        System.out.println("System cannot go to idle state");
    }

    @Override
    public void makeDrink(CoffeeMachine coffeeMachine, Drink drink) {
        System.out.println("Machine Brewing....");
        drink.prepare();
        coffeeMachine.setCoffeeMachineState(new IdleState());
    }

    @Override
    public void refill(CoffeeMachine coffeeMachine) {
        System.out.println("Machine is already preparing the drink wait!!!");
    }
}
