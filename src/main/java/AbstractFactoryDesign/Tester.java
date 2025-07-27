package AbstractFactoryDesign;

import FactoryzDesign.CoffeeFactory;
import FactoryzDesign.CoffeeServer;

public class Tester {
  public static void main(String[] args) {
    CoffeeServer coffeeServer = new CoffeeServer(new CoffeeFactory());
    coffeeServer.serve("Espresso");
  }
}
