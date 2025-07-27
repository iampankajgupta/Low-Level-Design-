package Solid.Liskov.usecase1.NotCompliant;

import java.util.ArrayList;
import java.util.List;

public class NotCompliant {

    /// Account Hiearchy
    // Check only if inheritance or interface is allowed -> then on;y liskov holds true

    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        Account fdAccount = new FixedDeposit();
        accounts.add(account);
        accounts.add(fdAccount);

        for(Account account1 : accounts) {
            account1.withDraw();
        }

    }
}


class Account {
    void deposit() {
        System.out.println("Deposition");
    }

    void withDraw() {
        System.out.println("WithDraw");
    }
}


// this is violating the Liskov Substitution Principle
class FixedDeposit extends Account {
    void withDraw() {
       throw new IllegalArgumentException("Not allowed to with draw from ");
    }
}