package Practice.ATM.State;

import Practice.ATM.Atm;
import Practice.ATM.Card;
import Practice.ATM.enums.OperationType;

public class OutOfServiceState implements AtmState{
    @Override
    public void insertCard(Card card, Atm atm) {
        throw new IllegalArgumentException("ATM is out of service");
    }

    @Override
    public void insertPin(String pin, Atm atm) {
        throw new IllegalArgumentException("ATM is out of service");
    }

    @Override
    public void selectOperation(OperationType operationType, Atm atm) {
        throw new IllegalArgumentException("ATM is out of service");
    }

    @Override
    public void enterAmount(Atm atm, int amount) {
        throw new IllegalArgumentException("ATM is out of service");
    }

    @Override
    public void cancel(Atm atm) {
        throw new IllegalArgumentException("ATM is out of service");
    }

    @Override
    public void clear(Atm atm) {
        throw new IllegalArgumentException("ATM is out of service");
    }
}
