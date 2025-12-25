package Practice.VendingMachine.State;

import Practice.VendingMachine.Coin;
import Practice.VendingMachine.VProduct;
import Practice.VendingMachine.VendingMachine;
import Practice.VendingMachine.VendingMachineState;

public class DispensingState extends VendingMachineState{

    private static VProduct product;
    @Override
    public void insertCoin(VendingMachine vendingMachineState, Coin coin) {

    }

    @Override
    public void cancel(VendingMachine vendingMachine) {

    }

    @Override
    public void dispense(VendingMachine vendingMachine, int totalCoin) {
        if(product != null) {
            System.out.println("Dispensing product id: "+product.getName());
        }
        System.out.println("No Product is being selected");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, String productId) {
        product = vendingMachine.getInventoryStore().getProduct(productId);
        System.out.println();
    }
}
