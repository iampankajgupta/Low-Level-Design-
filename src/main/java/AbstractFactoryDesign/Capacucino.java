package AbstractFactoryDesign;


public class Capacucino implements Coffee {

  public Entity entity;

  private final Bean bean;
  private final Sugar sugar;
  private final Milk milk;
  private final IngredientsFactory ingredientsFactory;
  private final Spice spice;

  public Capacucino(IngredientsFactory ingredientsFactory) {
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
