package Practice.ATM;

import java.util.HashMap;
import java.util.Map;

public class BankingService {
    // cardNumber -> Account mapping
    private static final Map<String, Account> accounts = new HashMap<>();

    static {
        accounts.put("1", new Account("123", "Pankaj", "Gupta", 200, "1234"));
    }

    public Account getAccountByCardNumber(String cardNumber) {
        if(accounts.containsKey(cardNumber)) {
            return accounts.get(cardNumber);
        }
        throw new IllegalArgumentException("Account does not exists!!");
    }

    // this is wrong and it should depend on atm
    public boolean validatePin(String pin, Atm atm) {
        String cardNo = atm.getSession().getCard().getCardNumber();
        if(accounts.containsKey(cardNo)) {
            Account account = accounts.get(cardNo);
            // get the pin;
            // if the pin equals to the entered pin then change the state
            return true;
        }else {
            throw new IllegalArgumentException("Pin entered is wrong");
        }
    }

    // just for the reference i kept this code
    public boolean validatePin(String cardNumber, String pin) {
        if(accounts.get(cardNumber) != null) {
            Account account = accounts.get(cardNumber);
            if(account.getPin().equals(pin)) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Card Number is invalid or account does not exists");
    }

    // Mixing ATM printing logic -> wrong code is kept just for reference
    public void showBalance(Atm atm) {
        if(atm.getSession().isAuthenticated()) {
            Account accountByCardNumber = atm.getBankingService().getAccountByCardNumber(atm.getSession().getCard().getCardNumber());
            System.out.println("Current Balance is: "+accountByCardNumber.getBalance());
            return;
        }
        throw new IllegalArgumentException("Account is not authenticated");
    }


    public int showBalance(String cardNumber) {
        return getAccountByCardNumber(cardNumber).getBalance();
    }

    public void updateBalance(String cardNumber, int amount) {
        Account accountByCardNumber = getAccountByCardNumber(cardNumber);
        accountByCardNumber.setBalance(accountByCardNumber.getBalance() - amount);
    }
}
