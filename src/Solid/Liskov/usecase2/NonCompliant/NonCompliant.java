package Solid.Liskov.usecase2.NonCompliant;

public class NonCompliant {

}

class PaymentProcessor {
    public void pay(String method) {
        if (method.equals("paypal")) {
            System.out.println("Paying using Paypal");
        }
        else throw new UnsupportedOperationException();
    }
}

// If you extend PaymentProcessor, you may override pay() inconsistently.

