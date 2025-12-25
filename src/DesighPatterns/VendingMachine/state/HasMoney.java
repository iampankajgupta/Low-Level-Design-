package DesighPatterns.VendingMachine.state;

import DesighPatterns.VendingMachine.Product;
import DesighPatterns.VendingMachine.VendingMachine;

import java.util.Map;

public class HasMoney implements VendingState{
    @Override
    public void insertMoney(VendingMachine vendingMachine, int amount) {
        vendingMachine.addBalance(amount);
        vendingMachine.setState(new HasMoney());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemCode, int quantity) {
        Map<String, Product> products = vendingMachine.getProducts();
        if(!products.containsKey(itemCode) || products.get(itemCode).getQuantity() == 0) {
            throw new IllegalArgumentException("Item code is not available, please select another item!!");
        }

        if(products.get(itemCode).getPrice() > vendingMachine.getBalance()) {
            throw new IllegalArgumentException("Please add more amount, Amount is not sufficient!!!");
        }

        System.out.println("ItemCode is being selected: "+itemCode);
        vendingMachine.setState(new Dispense());
        vendingMachine.setItemCode(itemCode);
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Please select the item before dispense!!");
        vendingMachine.setState(new Idle());
    }

    @Override
    public Double refund(VendingMachine vendingMachine) {
        System.out.println("Giving refund to the customer of amount: "+vendingMachine.getBalance());
        vendingMachine.setState(new Idle());
        return vendingMachine.getBalance();
    }
}
