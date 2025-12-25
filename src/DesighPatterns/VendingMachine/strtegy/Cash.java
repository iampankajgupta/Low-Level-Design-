package DesighPatterns.VendingMachine.strtegy;

public class Cash implements PaymentStrategy{


    @Override
    public void pay(int amount) {
        System.out.println("Amount of : "+amount+" is being passed to machine!!");
    }

    @Override
    public PaymentResult payW(int amount) {
        int retryCount = 0;
        return new PaymentResult();
    }

}
