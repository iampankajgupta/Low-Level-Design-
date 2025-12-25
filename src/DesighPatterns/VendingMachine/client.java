package DesighPatterns.VendingMachine;

import DesighPatterns.VendingMachine.strtegy.Cash;

public class client {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setPaymentStrategy(new Cash());
        vendingMachine.insertCoin(20);
        vendingMachine.selectItem("Coke", 1);
        vendingMachine.dispense();
    }
}
