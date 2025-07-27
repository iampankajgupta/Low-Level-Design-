package DesighPatterns.StateDesignPattern.ATM;

public class AtmMachine {
    private State currentState;
    private IdleState idleState;
    private CancelState cancelState;
    private CardInsertedState cardInsertedState;
    private DispenseState dispenseState;
    private PinEnteredState pinEnteredState;
    private TransactionSelectState transactionSelectState;
    double balance;

    public AtmMachine() {
        idleState = new IdleState();
        cancelState = new CancelState();
        cardInsertedState = new CardInsertedState();
        dispenseState = new DispenseState();
        currentState = idleState;
        transactionSelectState = new TransactionSelectState();
        balance = 0;

    }

    public void addBalance(double addBalance) {
        balance += addBalance;
    }

    public void deductBalance(double deductBalance) {
        if(balance >= deductBalance) {
            balance = balance - deductBalance;
        }else {
            System.out.println("Insufficient Balance");
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public void setIdleState(IdleState idleState) {
        this.idleState = idleState;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CardInsertedState getCardInsertedState() {
        return cardInsertedState;
    }

    public void setCardInsertedState(CardInsertedState cardInsertedState) {
        this.cardInsertedState = cardInsertedState;
    }

    public DispenseState getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(DispenseState dispenseState) {
        this.dispenseState = dispenseState;
    }

    public PinEnteredState getPinEnteredState() {
        return pinEnteredState;
    }

    public void setPinEnteredState(PinEnteredState pinEnteredState) {
        this.pinEnteredState = pinEnteredState;
    }

    public CancelState getCancelState() {
        return cancelState;
    }

    public void setCancelState(CancelState cancelState) {
        this.cancelState = cancelState;
    }

    public TransactionSelectState getTransactionSelectState() {
        return transactionSelectState;
    }

    public void setTransactionSelectState(TransactionSelectState transactionSelectState) {
        this.transactionSelectState = transactionSelectState;
    }
}
