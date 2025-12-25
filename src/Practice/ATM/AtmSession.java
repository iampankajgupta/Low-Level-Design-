package Practice.ATM;

import Practice.ATM.enums.OperationType;

public class AtmSession {
    private Card card;
    private OperationType selectedOperation;
    private int amount;
    private boolean authenticated;


    public AtmSession(Card card, OperationType selectedOperation, int amount, boolean authenticated) {
        this.card = card;
        this.selectedOperation = selectedOperation;
        this.amount = amount;
        this.authenticated = authenticated;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public OperationType getSelectedOperation() {
        return selectedOperation;
    }

    public void setSelectedOperation(OperationType selectedOperation) {
        this.selectedOperation = selectedOperation;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
