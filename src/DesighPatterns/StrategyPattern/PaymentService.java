package DesighPatterns.StrategyPattern;

public class PaymentService {

    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay() {
        paymentStrategy.processPayment(); // Polymorphic behaviour
    }
}
