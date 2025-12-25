package Practice.ATM;

import Practice.ATM.State.CardInsertedState;

public class client {
    public static void main(String[] args) {

        BankingService bankingService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser();
        Atm atm = new Atm(bankingService, cashDispenser);
        atm.setAtmState(new CardInsertedState());


    }
}
