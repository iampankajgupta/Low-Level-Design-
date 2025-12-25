package Practice.CoffeMachine;
import Practice.Ingredient.Ingredient;

import java.util.*;

public abstract class DrinkDecorator extends Drink {

    protected Drink baseDrink;

    public DrinkDecorator(Drink baseDrink) {
        this.baseDrink = baseDrink;
    }

    @Override
    public Map<Ingredient, Integer> getIngredients() {
        return baseDrink.getIngredients();
    }

    @Override
    protected void addIngredients() {
        // base behavior that every decorator must preserve
       baseDrink.addIngredients();
    }

}
