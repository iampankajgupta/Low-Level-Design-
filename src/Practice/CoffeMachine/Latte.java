package Practice.CoffeMachine;

import Practice.Ingredient.Ingredient;

import java.util.Map;

public class Latte extends Drink {

    @Override
    protected void addIngredients() {
        System.out.println("Adding milk + coffee beans for Latte...");
    }

    @Override
    public Map<Ingredient, Integer> getIngredients() {
        return Map.of(Ingredient.WATER, 30, Ingredient.MILK, 50, Ingredient.BEANS, 40);
    }

}
