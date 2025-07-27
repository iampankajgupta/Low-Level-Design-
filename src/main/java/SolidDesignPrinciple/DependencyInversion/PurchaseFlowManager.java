package SolidDesignPrinciple.DependencyInversion;

public class PurchaseFlowManager {

   final PaymentProcessor paymentProcessor;
   final NotificationManager notificationManager;

   // this is also called dependency injection
  // 
  public PurchaseFlowManager(PaymentProcessor paymentProcessor, NotificationManager notificationManager) {
    this.paymentProcessor = paymentProcessor;
    this.notificationManager = notificationManager;
  }


}
