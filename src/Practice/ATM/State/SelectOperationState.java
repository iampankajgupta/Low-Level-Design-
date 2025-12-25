package Practice.ATM.State;

import Practice.ATM.Atm;
import Practice.ATM.Card;
import Practice.ATM.enums.OperationType;

import java.util.Scanner;

public class SelectOperationState implements AtmState {
    @Override
    public void insertCard(Card card, Atm atm) {
        throw new IllegalArgumentException("Card is already being inserted!!, please select operationType");
    }

    @Override
    public void insertPin(String pin, Atm atm) {
        throw new IllegalArgumentException("Pin is already being entered, please select operationType!!");
    }

    @Override
    public void selectOperation(OperationType operationType, Atm atm) {
        Scanner scanner  = new Scanner(System.in);
        String operation = scanner.next();
        if(operationType.equals(OperationType.WITH_DRAW)) {
            atm.setAtmState(new MoneyInputState());
        }else if(operationType.equals(OperationType.CHECK_BALANCE)) {
            atm.getBankingService().showBalance(atm);
        }else {
            throw new IllegalArgumentException("Invalid operation type!!!");
        }
    }

    @Override
    public void enterAmount(Atm atm, int amount) {
        throw new IllegalArgumentException("Please select the operation!!!");
    }

    @Override
    public void cancel(Atm atm) {
        atm.getSession().setAuthenticated(false);
        atm.setAtmState(new IdleState());
    }

    @Override
    public void clear(Atm atm) {
        throw new IllegalArgumentException("Operation selection");
    }
}
