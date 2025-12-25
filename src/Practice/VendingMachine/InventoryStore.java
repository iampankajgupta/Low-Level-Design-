package Practice.VendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryStore {
    // Item and Quantity
    private static final Map<String, VProduct> products = new ConcurrentHashMap<>();

    static {
        products.putIfAbsent("RedBull", new VProduct("RedBull", 10, 5));
        products.putIfAbsent("Water", new VProduct("Water", 10, 3));
    }

    public VProduct getProduct(String productName) {
        if(products.containsKey(productName)) {
            return products.get(productName);
        }
        return null;
    }

    public VProduct createProduct(String name, int price, int quantity) {
        return products.computeIfAbsent(name, product -> new VProduct(name, price, quantity));
    }

    public boolean isProductExists(String productId) {
        return products.containsKey(productId);
    }

    public boolean hasProduct(String productId) {
        if(products.containsKey(productId)) {
            return products.get(productId).getQuantity() > 0;
        }
        return false;
    }

}
