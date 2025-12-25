package Practice.CoffeMachine;

import Practice.Ingredient.Ingredient;

import java.util.*;

public abstract class Drink {
    private String name;
    private int cost;
    public abstract Map<Ingredient, Integer> getIngredients();
    /*
    ⭐ What did you learn here?
        ✔ Template Method Pattern

        Base class defines the fixed algorithm
        Child classes override only specific steps.

        ✔ Strong OOP thinking

        Common logic stays in parent.
        Variable logic moves to children.

        ✔ Interview-level design

        Coffee machine is one of the most popular LLD tasks.
     */
    // Template Design Method
    public final void prepare() {
        boilWater();
        addIngredients();
        brew();
        pour();
        clean();
    }

    protected abstract void addIngredients();

    protected void brew() {
        System.out.println("Brewing the drink...");
    }

    protected void pour() {
        System.out.println("Pouring into cup...");
    }

    protected void clean() {
        System.out.println("Cleaning machine...");
    }

    protected void boilWater() {
        System.out.println("Boiling water...");
    }
}
