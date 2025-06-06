package LLD.StateDesignPattern.VendingMachine;

import java.util.List;

public class HasMoneyState implements State{
    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Coin Already is being inserted Please select the product from the shelves!!!");
    }

    @Override
    public void selectProduct(String codeId) {
        System.out.println("Product with id :"+codeId+" is being selected");
        List<Item> shelf = vendingMachine.getVendingShelves().get(codeId.substring(0,4));
        boolean itemFound = false;
        for(Item item : shelf) {
            String itemId = item.getItemId();
            if(itemId.equals(codeId) && item.getCost() <= vendingMachine.getBalance()) {
                vendingMachine.setBalance(item.getCost() - vendingMachine.getBalance());
                vendingMachine.setCurrentState(new DispensingState(vendingMachine));
                itemFound = true;
                break;
            }
        }
        if(!itemFound) {
            System.out.println("Please insert more coins, insufficient coin");
            vendingMachine.setCurrentState(vendingMachine.getIdleState());
        }
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select the product first");
    }

    @Override
    public void cancel() {
        vendingMachine.setBalance(0);
        vendingMachine.setCurrentState(new IdleState(vendingMachine));
    }
}
