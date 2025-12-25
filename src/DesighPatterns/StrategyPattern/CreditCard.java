package DesighPatterns.StrategyPattern;

public class CreditCard implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Paying using Credit Card");
    }
}
