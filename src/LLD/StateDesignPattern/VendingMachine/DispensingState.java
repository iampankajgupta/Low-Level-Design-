package LLD.StateDesignPattern.VendingMachine;

public class DispensingState implements State{
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("You cannot insert coin right now");
    }

    @Override
    public void selectProduct(String codeId) {
        System.out.println("You cannot select the product right now");
    }

    @Override
    public void dispenseProduct() {
        if(vendingMachine.getCurrentState() == vendingMachine.getDispensingState()) {
            System.out.println("Product is being dispatched");
            vendingMachine.setCurrentState(vendingMachine.getIdleState());
        }else {
            System.out.println("Product can't be dispatched");
        }
    }

    @Override
    public void cancel() {
        System.out.println("Cannot cancel product is being dispensing");
    }
}
