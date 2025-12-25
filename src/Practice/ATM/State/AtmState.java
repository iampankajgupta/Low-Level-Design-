package Practice.ATM.State;

import Practice.ATM.Atm;
import Practice.ATM.Card;
import Practice.ATM.enums.OperationType;

public interface AtmState {
    void insertCard(Card card, Atm atm);
    void insertPin(String pin, Atm atm);
    void selectOperation(OperationType operationType, Atm atm);
    void enterAmount(Atm atm, int amount);
    void cancel(Atm atm);
    void clear(Atm atm);
}
