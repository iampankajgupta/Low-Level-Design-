package SolidDesignPrinciple.DependencyInversion;

public class PurchaseFlow {

  private PurchaseFlowManager purchaseFlowManager;

  public PurchaseFlow(PurchaseFlowManager purchaseFlowManager) {
    this.purchaseFlowManager = purchaseFlowManager;
  }
}
