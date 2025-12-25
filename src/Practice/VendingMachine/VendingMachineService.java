package Practice.VendingMachine;

public class VendingMachineService {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine(new InventoryStore(), new CashManager());
        UserRequest userRequest = new UserRequest.Builder().setProductId("Water").setQuantity(1).build();
        // vendingMachine.takeOrder(userRequest);

    }
}
