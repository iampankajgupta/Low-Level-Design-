package DesighPatterns.VendingMachine.state;

import DesighPatterns.VendingMachine.VendingMachine;

public class OutOfStock implements VendingState{
    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        System.out.println("Items are outOfStock, insertMoney not allowed!!");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemCode, int quantity) {
        System.out.println("Items are outOfStock, selectItem not allowed!!");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Items are outOfStock, dispense not allowed!!");
    }

    @Override
    public Double refund(VendingMachine vendingMachine) {
        System.out.println("Items are outOfStock, refund not allowed!!");
        return 0.0;
    }
}
