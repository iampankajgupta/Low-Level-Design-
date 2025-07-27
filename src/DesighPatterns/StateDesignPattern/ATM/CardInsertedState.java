package DesighPatterns.StateDesignPattern.ATM;

public class CardInsertedState implements State {
    private AtmMachine atmMachine;

    @Override
    public void insertCard() {
        if(!atmMachine.getCurrentState().equals(atmMachine.getIdleState())) {
            System.out.println("Card already is being inserted");
        }
    }

    @Override
    public void enterPin(String pin) {
        if(atmMachine.getCurrentState().equals(atmMachine.getCardInsertedState())) {
            System.out.println("Your entered pin is :"+pin);
            atmMachine.setCurrentState(atmMachine.getPinEnteredState());
        }
    }

    @Override
    public void selectTransactionType(String transactionType) {

    }

    @Override
    public void checkBalance() {

    }

    @Override
    public void dispenseCash(int amount) {

    }

    @Override
    public void cancel() {

    }
}
