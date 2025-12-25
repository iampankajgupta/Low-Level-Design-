package Practice.ATM.State;

import Practice.ATM.Atm;
import Practice.ATM.AtmSession;
import Practice.ATM.Card;
import Practice.ATM.enums.OperationType;

import java.util.Scanner;

public class CardInsertedState implements AtmState {
    @Override
    public void insertCard(Card card, Atm atm) {
        atm.setSession(new AtmSession(card, null, 0, false));
    }

    @Override
    public void insertPin(String pin, Atm atm) {
        boolean validate = atm.getBankingService().validatePin(pin, atm);
        if(validate) {
            atm.setAtmState(new SelectOperationState());
            atm.getSession().setAuthenticated(true);
        }
        throw new IllegalArgumentException("Invalid pin!!!!");
    }

    @Override
    public void selectOperation(OperationType operationType, Atm atm) {
        throw new IllegalArgumentException("Please insert your card!!! before select operation");
    }

    @Override
    public void enterAmount(Atm atm, int amount) {
        throw new IllegalArgumentException("Please insert your card!!! before entering amount");
    }

    @Override
    public void cancel(Atm atm) {
        throw new IllegalArgumentException("Please insert your card!!! before cancel");
    }

    @Override
    public void clear(Atm atm) {
        throw new IllegalArgumentException("Please insert your card!!! before clear");
    }
}
