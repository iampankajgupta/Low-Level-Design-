package DesighPatterns.VendingMachine.state;

import DesighPatterns.VendingMachine.VendingMachine;

public interface VendingState {
    void insertMoney(VendingMachine vendingMachine, int amount);
    void selectItem(VendingMachine vendingMachine, String itemCode, int quantity);
    void dispense(VendingMachine vendingMachine);
    Double refund(VendingMachine vendingMachine);
}
