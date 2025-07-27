package AbstractFactoryDesign;

public class EspressoIntegredientFactory implements IngredientsFactory{
  @Override
  public Bean getBean() {
    return new IndianBean();
  }

  @Override
  public Milk getMilk() {
    return new CowMilk();
  }

  @Override
  public Sugar getSugar() {
    return new WhiteSugar();
  }

  @Override
  public Spice getSpice() {
    return null;
  }
}
