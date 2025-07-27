package SolidDesignPrinciple.DependencyInversion;

public class Cash implements PaymentProcessor{
  @Override
  public void pay() {
    System.out.println("Paying through cash...");
  }
}
