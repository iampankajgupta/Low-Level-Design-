package Practice.VendingMachine.State;

import Practice.VendingMachine.Coin;
import Practice.VendingMachine.VendingMachine;
import Practice.VendingMachine.VendingMachineState;

public class HasMoneyState extends VendingMachineState {
    private int totalCoin = 0;
    public HasMoneyState(Coin coin) {
        totalCoin+=coin.getCoin();
    }

    @Override
    public void insertCoin(VendingMachine vendingMachineState, Coin coin) {
        vendingMachineState.setVendingMachineState(new HasMoneyState(coin));
    }

    @Override
    public void cancel(VendingMachine vendingMachine) {

    }

    @Override
    public void dispense(VendingMachine vendingMachine, int totalCoin) {

    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, String productId) {

    }
}
