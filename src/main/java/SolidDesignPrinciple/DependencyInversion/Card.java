package SolidDesignPrinciple.DependencyInversion;

public class Card implements PaymentProcessor{
  @Override
  public void pay() {
    System.out.println("Paying through Card");
  }
}
