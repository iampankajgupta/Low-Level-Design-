package DesighPatterns.VendingMachine;

import DesighPatterns.VendingMachine.state.VendingState;
import  DesighPatterns.VendingMachine.state.Idle;
import DesighPatterns.VendingMachine.strtegy.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private double balance;
    private VendingState vendingState;
    private final Map<String, Product> products = new HashMap<>();
    private PaymentStrategy paymentStrategy;
    private String itemCode;

    public VendingMachine() {
        initialise();
        vendingState = new Idle();
    }

    private void initialise() {
        products.put("Coke", new Product("Coke", 10.0, 3));
        products.put("Milk", new Product("Milk", 15.0, 3));
        products.put("ColdCoffee",  new Product("ColdCoffee", 40.0, 3));
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setState(VendingState vendingState) {
        this.vendingState = vendingState;
    }

    public Double getBalance() {
        return balance;
    }

    public void insertCoin(int amount) {
        vendingState.insertMoney(this, amount);
    }

    public void selectItem(String itemCode, int quantity) {
        vendingState.selectItem(this, itemCode, quantity);
    }

    public void dispense() {
        vendingState.dispense(this);
    }

    public void refund() {
        vendingState.refund(this);
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public boolean isProductAvailable(String itemCode) {
        return products.containsKey(itemCode) && products.get(itemCode).getQuantity() > 0;
    }

    public void processPayment(int amount) {
        if(paymentStrategy == null) {
            throw new IllegalArgumentException("Payment strategy is not being defined");
        }
        paymentStrategy.payW(amount);
        balance += amount;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void updateProductCount() {
        Product product = products.get(this.itemCode);
        product.setQuantity(product.getQuantity() - 1);
    }

    public String getProduct() {
        return products.get(itemCode).getName();
    }

    public int getProductQuantity(String itemCode) {
        if(products.containsKey(itemCode)) {
            return products.get(itemCode).getQuantity();
        }
        return 0;
    }
}
