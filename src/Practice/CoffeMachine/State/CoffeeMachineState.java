package Practice.CoffeMachine.State;

import Practice.CoffeMachine.CoffeeMachine;
import Practice.CoffeMachine.Drink;

public interface CoffeeMachineState {

    void idle(CoffeeMachine coffeeMachine);
    void makeDrink(CoffeeMachine coffeeMachine, Drink drink);
    void refill(CoffeeMachine coffeeMachine);
}

/*

1. idle
2. brew
3. Out - of -ingredient
4. Maintenance
5. Cleaning


what would be the method which will be there

Idle -> Idle,  makeDrink, refill









 */