package Practice.ATM.State;

import Practice.ATM.Account;
import Practice.ATM.Atm;
import Practice.ATM.Card;
import Practice.ATM.enums.OperationType;

public class MoneyInputState implements AtmState{
    @Override
    public void insertCard(Card card, Atm atm) {
        throw new IllegalArgumentException("Card is already inserted!!!");
    }

    @Override
    public void insertPin(String pin, Atm atm) {
        throw new IllegalArgumentException("pin is being already entered!!");
    }

    @Override
    public void selectOperation(OperationType operationType, Atm atm) {
       throw new IllegalArgumentException(atm.getSession().getSelectedOperation().name() +  "is being already selected!!!");
    }

    // Business logic should not be there in state
    /*
    @Override
    public void enterAmount(Atm atm, int amount) {
       if(atm.getSession().isAuthenticated()) {
           Account accountByCardNumber = atm.getBankingService().getAccountByCardNumber(atm.getSession().getCard().getCardNumber());
           if(accountByCardNumber.getBalance() >= amount) {
               if(atm.getCashDispenser().isValidAmountForDispense(amount)) {
                   atm.getCashDispenser().dispense(amount);
                   atm.getBankingService().updateBalance(atm.getSession().getCard().getCardNumber(), amount);
               }
               atm.setAtmState(new IdleState());
           }else {
               throw new IllegalArgumentException("Insufficient balance!!!");
           }
       }
    }

     */

    @Override
    public void enterAmount(Atm atm, int amount) {
        if(atm.getSession().isAuthenticated()) {
            atm.processWithDrawl(amount);
        }
    }

    @Override
    public void cancel(Atm atm) {
        atm.getSession().setAuthenticated(false);
        atm.setAtmState(new IdleState());
    }

    @Override
    public void clear(Atm atm) {
        atm.setAtmState(new MoneyInputState());
    }
}
