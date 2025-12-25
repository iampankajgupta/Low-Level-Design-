package Practice.CoffeMachine;

import Practice.Ingredient.Ingredient;

import java.util.Map;

public class Espresso extends Drink{

    @Override
    protected void addIngredients() {
        System.out.println("Adding coffee beans only for Espresso...");
    }

    @Override
    public Map<Ingredient, Integer> getIngredients() {
        return Map.of(Ingredient.WATER, 30, Ingredient.BEANS, 40);
    }
}
