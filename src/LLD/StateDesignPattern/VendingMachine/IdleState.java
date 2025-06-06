package LLD.StateDesignPattern.VendingMachine;

public class IdleState implements State{

    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        if(vendingMachine.getCurrentState() == vendingMachine.getIdleState()) {
            vendingMachine.setBalance(amount);
            vendingMachine.setCurrentState(vendingMachine.getHasMoneyState());
        }
    }

    @Override
    public void selectProduct(String codeId) {
        System.out.println("Please Insert the coin first....");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please Insert the coin first....");
    }

    @Override
    public void cancel() {
        System.out.println("Please Insert the coin first....");
    }
}
