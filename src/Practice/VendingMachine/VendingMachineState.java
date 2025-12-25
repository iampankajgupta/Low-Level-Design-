package Practice.VendingMachine;

public abstract class VendingMachineState {
    public abstract void insertCoin(VendingMachine vendingMachineState, Coin coin);
    public abstract void cancel(VendingMachine vendingMachine);
    public abstract void dispense(VendingMachine vendingMachine, int totalCoin);
    public abstract void selectProduct(VendingMachine vendingMachine, String productId);

}
