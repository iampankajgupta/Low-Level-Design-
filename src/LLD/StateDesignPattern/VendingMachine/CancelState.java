package LLD.StateDesignPattern.VendingMachine;

public class CancelState implements State{

    private VendingMachine vendingMachine;

    public CancelState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertCoin(int amount) {
        System.out.println("Is in cancel state cannot insert coin");
    }

    @Override
    public void selectProduct(String codeId) {
        System.out.println("Is in cancel state cannot select product");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Is in cancel state cannot dispense");
    }

    @Override
    public void cancel() {
        if(vendingMachine.getCurrentState() != vendingMachine.getIdleState()) {
            vendingMachine.setCurrentState(vendingMachine.getIdleState());
        }
    }
}
