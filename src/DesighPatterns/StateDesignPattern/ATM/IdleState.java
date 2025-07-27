package DesighPatterns.StateDesignPattern.ATM;

public class IdleState implements State{

    private AtmMachine atmMachine;

    @Override
    public void insertCard() {
        System.out.println("Card has been inserted, Please enter pin");
        atmMachine.setCurrentState(atmMachine.getCardInsertedState());
    }

    @Override
    public void enterPin(String pin) {

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
