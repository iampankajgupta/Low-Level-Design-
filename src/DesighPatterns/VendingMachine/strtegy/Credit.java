package DesighPatterns.VendingMachine.strtegy;

public class Credit implements PaymentStrategy{
    private String cardNumber;
    private String cvv;
    private String pin;

    private static final int RETRY_COUNT = 3;

    public Credit(String cardNumber, String cvv, String pin) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.pin = pin;
    }

    @Override
    public void pay(int amount) {
        // to handle failures we can add separate logic for retry here
        System.out.println("Paying via credit card!!!");
    }

    @Override
    public PaymentResult payW(int amount) {
        return new PaymentResult();
    }
}
