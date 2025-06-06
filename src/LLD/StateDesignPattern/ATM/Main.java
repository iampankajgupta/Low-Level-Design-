package LLD.StateDesignPattern.ATM;

public class Main {
    public static void main(String[] args) {
        AtmMachine atmMachine = new AtmMachine();
        atmMachine.setBalance(1000);
        atmMachine.getCardInsertedState().insertCard();
        atmMachine.getPinEnteredState().enterPin("123");
        atmMachine.getTransactionSelectState().selectTransactionType("Current");
        atmMachine.getDispenseState().dispenseCash(1001);

    }
}
