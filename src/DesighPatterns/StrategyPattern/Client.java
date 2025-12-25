package DesighPatterns.StrategyPattern;

public class Client {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new UPI();
        PaymentService paymentService = new PaymentService(new UPI());
        paymentService.pay();
    }
}
