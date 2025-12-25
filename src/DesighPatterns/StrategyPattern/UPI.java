package DesighPatterns.StrategyPattern;

public class UPI implements PaymentStrategy{
    @Override
    public void processPayment() {
        System.out.println("Processing using UPI");
    }
}
