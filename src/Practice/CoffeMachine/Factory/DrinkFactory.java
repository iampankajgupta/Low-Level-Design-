package Practice.CoffeMachine.Factory;

import Practice.CoffeMachine.Drink;
import Practice.CoffeMachine.DrinkType;
import Practice.CoffeMachine.Espresso;
import Practice.CoffeMachine.Latte;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.*;

public class DrinkFactory {
    // this is not scalable and violates OCP
    public static Drink createDrink(DrinkType drinkType) {
        if(drinkType.equals(DrinkType.ESPRESSO)) {
            return new Espresso();
        }else if(drinkType.equals(DrinkType.LATTE)) {
            return new Latte();
        }
        throw new IllegalArgumentException("No Drink Type matches");
    }

    // We can use Registry based Map
    // More scalable and extensible
    private static final Map<DrinkType, Supplier<Drink>> registry = new HashMap<>();

    static {
        // this is also correct but more scalable way would be
        /*
        registry.put(DrinkType.ESPRESSO, new Espresso());
        registry.put(DrinkType.LATTE, new Latte());
         */

        registry.putIfAbsent(DrinkType.ESPRESSO, Espresso::new);
        registry.putIfAbsent(DrinkType.LATTE, Latte::new);
    }

    public static Drink create(DrinkType type) {
        Supplier<Drink> s = registry.get(type);
        if (s == null) throw new IllegalArgumentException("Unknown drink");
        return s.get();
    }

    /*
        public static void register(DrinkType type, Drink supplier) {
            registry.put(type, supplier);
        }
     */

    public static void register(DrinkType type, Supplier<Drink> supplier) {
        registry.put(type, supplier);
    }
}
