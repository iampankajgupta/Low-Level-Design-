package DesighPatterns.VendingMachine.strtegy;

import DesighPatterns.VendingMachine.enums.PaymentStatus;

public class Debit implements PaymentStrategy{
    private String cardNumber;
    private String cvv;
    private String pin;
    private static final int MAX_RETRY = 3;

    public Debit(String cardNumber, String cvv, String pin) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.pin = pin;
    }



    @Override
    public void pay(int amount) {
        System.out.println("Paying via debit card!!!");
    }

    @Override
    public PaymentResult payW(int amount) {
        int retryCount = 0;
        PaymentResult paymentResult = new PaymentResult();
        while(retryCount < MAX_RETRY) {
            // async call to api for payment
            boolean isSuccess = isPaymentSuccess(amount);
            if(isSuccess) {
                // to mimic
                paymentResult.setPaymentStatus(PaymentStatus.SUCCESS.name());
                return paymentResult;
            }
        }
        paymentResult.setPaymentStatus(PaymentStatus.FAILED.name());
        return paymentResult;
    }


    public boolean isPaymentSuccess(int amount) {
        return true;
    }
}
