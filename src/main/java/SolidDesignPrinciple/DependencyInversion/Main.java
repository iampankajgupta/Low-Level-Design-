package SolidDesignPrinciple.DependencyInversion;

public class Main {
  public static void main(String[] args) {

    User user = new User("Pankaj","Gupta","");
    Product product = new Product("A",123L);
    PurchaseFlowManager purchaseFlowManager = new PurchaseFlowManager(new UPI(), new SMS());
    purchaseFlowManager.paymentProcessor.pay();
    purchaseFlowManager.notificationManager.notifySender();
  }
}
