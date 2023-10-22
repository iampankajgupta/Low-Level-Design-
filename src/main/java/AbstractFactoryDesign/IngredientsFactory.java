package AbstractFactoryDesign;

public interface IngredientsFactory {

  Bean getBean();
  Milk getMilk();
  Sugar getSugar();
  Spice getSpice();
}
