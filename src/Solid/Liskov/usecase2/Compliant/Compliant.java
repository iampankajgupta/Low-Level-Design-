package Solid.Liskov.usecase2.Compliant;

public class Compliant {
}


/*
        interface PaymentStrategy {
            void pay();
        }

        class PayPalPayment implements PaymentStrategy {
            public void pay() {
                System.out.println("Paid using PayPal");
            }
        }

        class CreditCardPayment implements PaymentStrategy {
            public void pay() {
                System.out.println("Paid using Credit Card");
            }
        }

Why better: All PaymentStrategy objects are valid substitutions — compliant with LSP.


 */