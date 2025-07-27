package DesighPatterns.StateDesignPattern.ATM;

public interface State {

    void insertCard();
    void enterPin(String pin);
    void selectTransactionType(String transactionType);
    void checkBalance();
    void dispenseCash(int amount);
    void cancel();
}
