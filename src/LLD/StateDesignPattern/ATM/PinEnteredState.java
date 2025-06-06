package LLD.StateDesignPattern.ATM;

public class PinEnteredState implements State{

    private AtmMachine atmMachine;
    @Override
    public void insertCard() {

    }

    @Override
    public void enterPin(String pin) {
        if(atmMachine.getCurrentState().equals(atmMachine.getPinEnteredState())) {
            System.out.println("Enter the pin:");
            System.out.println("Pin Entered is: "+pin);
            atmMachine.setCurrentState(atmMachine.getTransactionSelectState());
        }

    }

    @Override
    public void selectTransactionType(String transactionType) {
        if(atmMachine.getCurrentState().equals(atmMachine.getPinEnteredState())) {
            System.out.println("Enter the transaction account from which amount should be deducted");
            // clarify different transaction types
            System.out.println("Selected Transaction types is :"+transactionType);
            atmMachine.setCurrentState(atmMachine.getDispenseState());
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
