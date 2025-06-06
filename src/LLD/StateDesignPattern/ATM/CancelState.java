package LLD.StateDesignPattern.ATM;

public class CancelState implements State{
    private AtmMachine atmMachine;
    @Override
    public void insertCard() {
        System.out.println("Cannot insertCard on cancel state");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Cannot enterPin on cancel state");
    }

    @Override
    public void selectTransactionType(String transactionType) {
        System.out.println("Cannot selectTransactionType on cancel state");
    }

    @Override
    public void checkBalance() {
        System.out.println("Cannot checkBalance on cancel state");
    }

    @Override
    public void dispenseCash(int amount) {
        System.out.println("Cannot dispense cash on cancel state");
    }

    @Override
    public void cancel() {
        System.out.println("Cancelling the transaction");
        atmMachine.setCurrentState(atmMachine.getIdleState());
    }
}
