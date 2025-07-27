package DesighPatterns.StateDesignPattern.VendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private IdleState idleState;
    private HasMoneyState hasMoneyState;
    private DispensingState dispensingState;
    private CancelState cancelState;
    // shelfId, List of Shelves
    private Map<String, List<Item>> vendingShelves;

    private State currentState;
    private int balance;

    public VendingMachine() {
        this.idleState = new IdleState(this);
        this.hasMoneyState = new HasMoneyState(this);
        this.dispensingState = new DispensingState(this);
        this.cancelState = new CancelState(this);
        this.currentState = idleState;
        this.vendingShelves = new HashMap<>();
        this.balance = 0;
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public void setIdleState(IdleState idleState) {
        this.idleState = idleState;
    }

    public HasMoneyState getHasMoneyState() {
        return hasMoneyState;
    }

    public void setHasMoneyState(HasMoneyState hasMoneyState) {
        this.hasMoneyState = hasMoneyState;
    }

    public DispensingState getDispensingState() {
        return dispensingState;
    }

    public void setDispensingState(DispensingState dispensingState) {
        this.dispensingState = dispensingState;
    }

    public CancelState getCancelState() {
        return cancelState;
    }

    public void setCancelState(CancelState cancelState) {
        this.cancelState = cancelState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Map<String, List<Item>> getVendingShelves() {
        return vendingShelves;
    }

    public void setVendingShelves(Map<String, List<Item>> vendingShelves) {
        this.vendingShelves = vendingShelves;
    }
}
