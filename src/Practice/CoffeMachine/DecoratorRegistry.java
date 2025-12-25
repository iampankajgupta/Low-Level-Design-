package Practice.CoffeMachine;

import Practice.DecoratorOption;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class DecoratorRegistry {
    private static Map<DecoratorOption, Function<Drink,Drink>> decoratorOptionDrinkMap =  new ConcurrentHashMap<>();
    static {
        decoratorOptionDrinkMap.put(DecoratorOption.EXTRA_SUGAR, ExtraSugar::new);
        decoratorOptionDrinkMap.put(DecoratorOption.EXTRA_MILK, ExtraMilkDecorator::new);
    }

    public static void create(DecoratorOption decoratorOption, Drink drink2) {
        decoratorOptionDrinkMap.putIfAbsent(decoratorOption, drink -> drink2);
    }

    // we are not changing any state here i.e synchronized is not required
    public static Drink applyOptions(Drink drink, List<DecoratorOption> options) {
        for(DecoratorOption opt : options) {
            // IMPPP --->  new ExtraSugar(drink) i.e function is being used
            drink = decoratorOptionDrinkMap.get(opt).apply(drink);
        }
        return drink;
    }

}
