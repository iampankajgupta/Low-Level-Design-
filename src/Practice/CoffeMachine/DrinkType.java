package Practice.CoffeMachine;

import java.util.Map;

public enum DrinkType {
    ESPRESSO(Map.of("water", 50, "milk", 0, "beans", 18)),
    LATTE(Map.of("water", 30, "milk", 150, "beans", 20)),
    CAPPUCCINO(Map.of("water", 30, "milk", 100, "beans", 14));

    private final Map<String, Integer> ingredients;

    DrinkType(Map<String, Integer> ingredients) {
        this.ingredients = ingredients;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
