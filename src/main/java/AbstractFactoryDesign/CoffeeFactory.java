package AbstractFactoryDesign;


public class CoffeeFactory implements AbstractFactory {

  @Override
  public Coffee getCoffee(String coffeeType) {
    Coffee coffee;

    // Before
//    if(coffeeType.equals("Espresso")) coffee = new Espresso(new AmericanBean(), new WhiteSugar(),new CowMilk());
//    else coffee = new Capacucino(new IndianBean(), new BrownSugar(),new BuffaloMilk());
//    return coffee;

//    After
    // in this way anything changes is ingredient this class will not change cause we have pass
    // factory of ingredients.but if pass ingredient separately then
    // if anything changes then this class is needs to change
    if(coffeeType.equals("Espresso")) coffee = new Espresso(new EspressoIntegredientFactory());
    else coffee = new Capacucino(new CapacucionIntegredientFactory());
    return coffee;
  }
}

// Creational resp wrt coffee
// Remembering the receipe/ingredients
// abstract out ingredient knowledge
// e: abstract entity : ingredientFactory
// AbstractFactory
// T1 is tied to a specific combination of ingredients


// here we are centralise the creation of object
// but we have decrease the usage of new keyword as much as possible

//  Factory Pattern with if-else is still violating the Open-Closed Principle.
//    If we need to create a new object of same **category** then we need to change the class. How can we avoid this ?
//
//   ans -->  Somewhere in the codebase, this if else conditions have to be there. Using factory pattern ensures that all such if else
//   conditions and usage of new keywords are localised inside a single class only.
//
//    imagine what would have happened if there was no factory. Tons of classes would have had such if else conditions pertaining to object creation.
//    So the point of using this pattern is to centralise these conditions inside one particular
//class so that remainMing codebase is clean.


