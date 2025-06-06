package LLD.StateDesignPattern.VendingMachine;

public interface State {
    void insertCoin(int amount);
    void selectProduct(String codeId);
    void dispenseProduct();
    void cancel();
}
