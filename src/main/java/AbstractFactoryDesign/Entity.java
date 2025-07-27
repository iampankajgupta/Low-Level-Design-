package AbstractFactoryDesign;

public interface Entity {

  public default Bean getBean(Bean bean) {
    return bean;
  }

  public default Milk getMilk(Milk milk) {
    return milk;
  }

  public default Sugar getSugar(Sugar sugar) {
    return sugar;
  }
}
