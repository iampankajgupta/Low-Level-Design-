package AbstractFactoryDesign;

public class DefaultIngredientFactory implements IngredientsFactory{
  @Override
  public Bean getBean() {
    return null;
  }

  @Override
  public Milk getMilk() {
    return null;
  }

  @Override
  public Sugar getSugar() {
    return null;
  }

  @Override
  public Spice getSpice() {
    return null;
  }
}
