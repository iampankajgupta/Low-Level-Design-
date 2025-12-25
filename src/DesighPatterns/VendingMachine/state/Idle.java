package DesighPatterns.VendingMachine.state;

import DesighPatterns.VendingMachine.VendingMachine;

public class Idle implements VendingState{
    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        vendingMachine.addBalance(amount);
        vendingMachine.setState(new HasMoney());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemCode, int quantity) {
        System.out.println("Please insert the money before select item!!");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("No product selected for dispense!!");
    }

    @Override
    public Double refund(VendingMachine vendingMachine) {
        System.out.println("No money to refund!!");
        return 0.0;

    }
}
