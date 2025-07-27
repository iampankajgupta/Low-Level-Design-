package AbstractFactoryDesign;

public class CapacucionIntegredientFactory implements IngredientsFactory{
  @Override
  public Bean getBean() {
    return new AmericanBean();
  }

  @Override
  public Milk getMilk() {
    return new BuffaloMilk();
  }

  @Override
  public Sugar getSugar() {
    return new BrownSugar();
  }

  @Override
  public Spice getSpice() {
    return null;
  }
}
