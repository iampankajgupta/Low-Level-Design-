package FactoryzDesign;

public class CoffeeServer {

  private final AbstractFactory abstractFactory;

  public CoffeeServer(AbstractFactory abstractFactory) {
    this.abstractFactory = abstractFactory;
  }

  public Coffee serve(String coffeeType) {
    return abstractFactory.getCoffee("Espresso");
  }

//  public Coffee serve(String coffeeType) {
//    CoffeeFactory coffeeFactory = new CoffeeFactory();
//    return coffeeFactory.getCoffee("Espresso");
//  }
}

//CoffeeServer is dependent on CoffeeFactory instead of Concrete Type

// then
// Instead of depending on Concrete class depend on Abstraction