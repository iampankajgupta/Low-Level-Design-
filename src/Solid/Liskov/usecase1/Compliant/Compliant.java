package Solid.Liskov.usecase1.Compliant;

public class Compliant {

    public static void main(String[] args) {
        WithDrawable withDrawable = new SavingAccount();
        Depositable depositable = new FixedDepositAccount();
        Depositable depositable2 = new SavingAccount();




    }
}

// Benefit: Now behavior is modeled more precisely using interfaces — clients use only what they need.
class SavingAccount implements WithDrawable, Depositable {

    @Override
    public void deposit(Double amount) {
        System.out.println(amount +" has been deposited from account");
    }

    @Override
    public void withDrawable(Double amount) {
        System.out.println(amount +" has been withDrawed from account");
    }
}

class FixedDepositAccount implements Depositable {
    @Override
    public void deposit(Double amount) {
        System.out.println(amount +" has been deposited from account");
    }
}
