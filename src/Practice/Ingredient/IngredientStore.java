package Practice.Ingredient;

import Practice.CoffeMachine.Drink;

import java.util.Map;

public class IngredientStore {
    private int water;
    private int milk;
    private int beans;

    public IngredientStore(int water, int milk, int beans) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
    }
    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getbeans() {
        return beans;
    }

    public void setbeans(int beans) {
        this.beans = beans;
    }

    // this should be private so that no can call this method directly same for consume method
    private boolean hasEnoughIngredients(Drink drink) {
        Map<Ingredient, Integer> ingredients = drink.getIngredients();
        for(Map.Entry<Ingredient, Integer> map : ingredients.entrySet()) {
            // if it is water then check its quantity is less than total water
            Ingredient key = map.getKey();
            int value =  map.getValue();
            if(key.equals(Ingredient.WATER) && value > water) {
                return false;
            }
            // if it is water then check its quantity is less than total beans
            else if(key.equals(Ingredient.BEANS) && value > beans) {
                return false;
            }
            // if it is water then check its quantity is less than total milk
            else if(key.equals(Ingredient.MILK) && value > milk) {
                return false;
            }
        }
        return true;

    }

    private void consumeIngredients(Drink drink) {
        Map<Ingredient, Integer> ingredients = drink.getIngredients();
        for(Map.Entry<Ingredient, Integer> map : ingredients.entrySet()) {
            // if it is water then check its quantity is less than total water
            Ingredient key = map.getKey();
            int value =  map.getValue();
            if(key.equals(Ingredient.WATER)) {
                water -= value;
            }
            // if it is water then check its quantity is less than total beans
            else if(key.equals(Ingredient.BEANS)) {
                beans -= value;
            }
            // if it is water then check its quantity is less than total milk
            else if(key.equals(Ingredient.MILK)) {
                milk -= value;
            }
        }
    }

    public synchronized boolean tryConsume(Drink drink) {
        if(hasEnoughIngredients(drink)) {
            consumeIngredients(drink);
            return true;
        }
        return false;
    }
}
