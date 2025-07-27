package DesighPatterns.StateDesignPattern.ATM;

public class TransactionSelectState implements State{
    private AtmMachine atmMachine;

    @Override
    public void insertCard() {

    }

    @Override
    public void enterPin(String pin) {

    }

    @Override
    public void selectTransactionType(String transactionType) {
        if(atmMachine.getCurrentState().equals(atmMachine.getTransactionSelectState())) {
            System.out.println("Please Enter the transaction type");
            if(!transactionType.isEmpty()) {
                System.out.println("Your Transaction type is: "+transactionType);
                atmMachine.setCurrentState(atmMachine.getDispenseState());
            }
        }
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
