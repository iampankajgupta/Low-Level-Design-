package Practice.CoffeMachine;

import Practice.Ingredient.Ingredient;

import java.util.Map;

public class Cappuccino extends Drink{
    @Override
    public Map<Ingredient, Integer> getIngredients() {
        return Map.of(Ingredient.MILK, 40, Ingredient.WATER, 30, Ingredient.BEANS, 15);
    }

    @Override
    protected void addIngredients() {
        System.out.println("Adding frothed milk for Cappuccino...");
    }
}
