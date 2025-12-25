package DesighPatterns.StateDesignPattern.VendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
        List<Item> shelf1Item = new ArrayList<>();
        shelf1Item.add(new Item("E313001", 10));
        shelf1Item.add(new Item("E313002", 5));
        shelf1Item.add(new Item("E313003", 10));
        shelf1Item.add(new Item("E313004", 10));

        List<Item> shelf2Item = new ArrayList<>();
        shelf2Item.add(new Item("E314001", 10));
        shelf2Item.add(new Item("E314002", 5));
        shelf2Item.add(new Item("E314003", 10));
        shelf2Item.add(new Item("E314004", 10));

        Map<String, List<Item>> vendingShelves = new HashMap<>();
        vendingShelves.put("E313", shelf1Item);
        vendingShelves.put("E314", shelf2Item);

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setVendingShelves(vendingShelves);
        vendingMachine.getIdleState().insertCoin(5);
        vendingMachine.getHasMoneyState().selectProduct("E313001");
        vendingMachine.getDispensingState().dispenseProduct();
        
         */

        /*
        * Great question! You're thinking in the right direction by examining your design against **SOLID principles**, especially the **Interface Segregation Principle (ISP)**.

        ---

        ### ✅ First, what does **Interface Segregation Principle** say?

        > **“Clients should not be forced to depend on methods they do not use.”**

        In other words, an interface should have only the methods that are **relevant to the implementing class**.

        ---
        ### 🔍 Now, let's look at your case:

        You have an interface like this (assumed):

        ```java
        public interface State {
            void insertCoin(int amount);
            void selectProduct(String codeId);
            void dispenseProduct();
            void cancel();
        }
        ```
        And `IdleState` implements **all** of these methods, even though **only `insertCoin` is valid in this state**, and others are just printing “Please Insert the coin first...”.

        ---

        ### ❓ So, does this violate ISP?

        **Not necessarily.**

        This is actually **typical and acceptable** in a **State design pattern**, because:

        * The purpose of each `State` implementation is to handle all the methods **according to that state’s behavior**.
        * It’s **not** that `IdleState` doesn’t need `selectProduct()` — it just behaves differently in `IdleState` than in `HasMoneyState`.

        Each method is still meaningful in every state — just handled differently.

        > ✅ So **this does not violate ISP**, because each method is relevant — just that its behavior varies by state.

        ---

        ### 🧠 However, a better question to ask is:

        > ❓ *Is my interface bloated with operations that logically belong to separate concerns?*

        In your case, all four operations (`insertCoin`, `selectProduct`, `dispenseProduct`, `cancel`) are directly tied to the lifecycle of a vending machine — so bundling them into one `State` interface is reasonable.

        ---
        ### ✅ TL;DR

        * **No**, your implementation **does not violate the Interface Segregation Principle**, because:

          * All methods are relevant to the state, even if they’re no-ops or warnings.
          * This is expected behavior in the **State Design Pattern**.

        Let me know if you'd like to explore a variation with finer-grained interfaces (though not common in State Pattern unless your context is more complex).
        *
        * */

    }
}
