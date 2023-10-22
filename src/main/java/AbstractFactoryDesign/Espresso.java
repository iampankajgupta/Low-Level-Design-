package AbstractFactoryDesign;

public class Espresso implements Coffee {

  private final Bean bean;
  private final Sugar sugar;
  private final Milk milk;
  private final IngredientsFactory ingredientsFactory;
  private final Spice spice;

  public Espresso(IngredientsFactory ingredientsFactory) {
    this.ingredientsFactory = ingredientsFactory;
    this.bean = ingredientsFactory.getBean();
    this.sugar = ingredientsFactory.getSugar();
    this.milk = ingredientsFactory.getMilk();
    this.spice = ingredientsFactory.getSpice();
  }

  @Override
  public void brew() {

  }

  @Override
  public void boil() {

  }
}
