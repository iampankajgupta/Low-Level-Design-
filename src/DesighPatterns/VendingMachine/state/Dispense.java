package DesighPatterns.VendingMachine.state;

import DesighPatterns.VendingMachine.VendingMachine;

public class Dispense implements VendingState{
    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        System.out.println("Item is being dispensing, insert coin not allowed!!");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemCode, int quantity) {
        System.out.println("Item is being dispensing, selectItem not allowed!!");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Dispensing Item : "+vendingMachine.getProduct());
        // once dispense then update the product count in products map
        vendingMachine.updateProductCount();
        /*
            // below logic knows too much
            // if product quantity is zero then remove product;
            int productQuantity = vendingMachine.getProductQuantity(vendingMachine.getItemCode());
            // vending Machine call remove product;
            // if after removeal products size is zero then make it go for OutOfStock state
            // else in idle state
         */

        // call vending machine to for removal and

        if(vendingMachine.getProducts().isEmpty()) {
            vendingMachine.setState(new OutOfStock());
            return;
        }
        vendingMachine.setState(new Idle());
    }

    @Override
    public Double refund(VendingMachine vendingMachine) {
        System.out.println("Item is being dispensing, refund not allowed!!");
        return 0.0;
    }
}
