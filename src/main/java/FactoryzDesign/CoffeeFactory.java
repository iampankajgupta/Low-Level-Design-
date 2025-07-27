package FactoryzDesign;

public class CoffeeFactory implements AbstractFactory {

  @Override
  public Coffee getCoffee(String coffeeType) {
    Coffee coffee;
    if(coffeeType.equals("Espresso")) coffee = new Espresso();
    else coffee = new Capacucino();
    return coffee;
  }
}

// here we are centralise the creation of object
// it is

//  Factory Pattern with if-else is still violating the Open-Closed Principle.
//    If we need to create a new object of same **category** then we need to change the class. How can we avoid this ?
//
//   ans -->  Somewhere in the codebase, those if else conditions have to be there. Using factory pattern ensures that all such if else
//   conditions and usage of new keywords are localised inside a single class only.
//
//    imagine what would have happened if there was no factory. Tons of classes would have had such if else conditions pertaining to object creation.
//    So the point of using this pattern is to centralise these conditions inside one particular
//class so that remainMing codebase is clean.
