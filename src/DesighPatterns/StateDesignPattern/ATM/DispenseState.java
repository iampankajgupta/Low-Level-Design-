package DesighPatterns.StateDesignPattern.ATM;

public class DispenseState implements State{

    private AtmMachine atmMachine;

    @Override
    public void insertCard() {

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
        if(atmMachine.getCurrentState().equals(atmMachine.getDispenseState()) && amount <= atmMachine.getBalance()) {
            atmMachine.setBalance(atmMachine.getBalance() - amount);
            System.out.println("Amount: "+amount+" has been dispensing from atm machine");
            atmMachine.setCurrentState(atmMachine.getIdleState());
        }else {
            System.out.println("Insufficient Balance");
            atmMachine.setCurrentState(atmMachine.getCancelState());
        }
    }

    @Override
    public void cancel() {

    }
}
