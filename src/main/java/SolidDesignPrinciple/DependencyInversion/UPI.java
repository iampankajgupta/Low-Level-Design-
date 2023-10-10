package SolidDesignPrinciple.DependencyInversion;

public class UPI implements PaymentProcessor{
  @Override
  public void pay() {
    System.out.println("Paying through UPI");
  }
}
