package Practice.ATM.State;

import Practice.ATM.Atm;
import Practice.ATM.Card;
import Practice.ATM.enums.OperationType;

public class IdleState implements AtmState {

    @Override
    public void insertCard(Card card, Atm atm) {

    }

    @Override
    public void insertPin(String pin, Atm atm) {
        throw new IllegalArgumentException("Please insert card before insert pin");
    }

    @Override
    public void selectOperation(OperationType operationType, Atm atm) {

    }

    @Override
    public void enterAmount(Atm atm, int amount) {

    }

    @Override
    public void cancel(Atm atm) {

    }

    @Override
    public void clear(Atm atm) {

    }
}
