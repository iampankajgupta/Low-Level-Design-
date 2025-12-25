package Practice.VendingMachine.State;

import Practice.VendingMachine.Coin;
import Practice.VendingMachine.VendingMachine;
import Practice.VendingMachine.VendingMachineState;

public class Idle extends VendingMachineState {

    @Override
    public void insertCoin(VendingMachine vendingMachineState, Coin coin) {
        vendingMachineState.setVendingMachineState(new HasMoneyState(coin));
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {
        System.out.println("Already in idle state");
    }

    @Override
    public void dispense(VendingMachine vendingMachine, int totalCoin) {
        System.out.println("Vending Machine in idle state cannot dispense");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, String productId) {
        System.out.println("Please Insert Coin before product selection");
    }
}
