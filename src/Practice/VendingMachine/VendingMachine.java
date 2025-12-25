package Practice.VendingMachine;

import Practice.VendingMachine.State.Idle;

public class VendingMachine {
    private VendingMachineState vendingMachineState;
    private InventoryStore inventoryStore;
    private CashManager cashManager;
    private static int totalCoin = 0;

    public VendingMachine(InventoryStore inventoryStore, CashManager cashManager) {
        this.vendingMachineState = new Idle();
        this.inventoryStore = inventoryStore;
        this.cashManager = cashManager;
    }

    public void insertCoin(Coin coin) {
        totalCoin +=coin.getCoin();
        vendingMachineState.insertCoin(this, coin);
    }

    // assuming 1 product per order
    public void selectProduct(String productId) {
        boolean isEnough = inventoryStore.hasProduct(productId);
        if(isEnough) {
            vendingMachineState.selectProduct(this, productId);
        }
    }

    public void dispense() {
        vendingMachineState.dispense(this, totalCoin);
        totalCoin = 0;
    }

    public void cancel() {
        vendingMachineState.cancel(this);
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public InventoryStore getInventoryStore() {
        return inventoryStore;
    }

    public void setInventoryStore(InventoryStore inventoryStore) {
        this.inventoryStore = inventoryStore;
    }

    public CashManager getCashManager() {
        return cashManager;
    }

    public void setCashManager(CashManager cashManager) {
        this.cashManager = cashManager;
    }

}
