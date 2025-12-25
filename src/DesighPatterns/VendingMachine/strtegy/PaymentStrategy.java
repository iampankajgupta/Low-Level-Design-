package DesighPatterns.VendingMachine.strtegy;

public interface PaymentStrategy {
    void pay(int amount);
    PaymentResult payW(int amount);
}
