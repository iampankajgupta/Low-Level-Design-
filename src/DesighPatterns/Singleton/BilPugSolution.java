package DesighPatterns.Singleton;

public class BilPugSolution {

    /*
    * If multiple classes call the getInstance() method concurrently or independently, the Bill Pugh Singleton Pattern still ensures that:

    ✅ Only one instance is created and shared globally.
    📌 Why?
    Java’s class loading and initialization mechanism guarantees that:

    The inner static class (DbConnectionHelper) is only loaded once, even if multiple threads or classes call getInstance().

    When DbConnectionHelper is loaded, the JVM initializes the static field INSTANCE in a thread-safe way.

    So, no matter how many classes or threads call BilPugSolution.getInstance(), they all get the same instance.
    *
    *
    * Great question! Let's clarify what happens when **multiple threads** or **multiple classes** call `getInstance()` of the Bill Pugh Singleton.

        ### 💡 Summary Answer:

        > ✅ **Only one singleton instance is ever created, no matter how many times or from how many threads `getInstance()` is called.**

        ---

        ### 🧠 Why?

        Because of **how Java loads static nested classes**:

        ```java
        private static class DbConnectionHelper {
            private static final BilPugSolution bilPugSolution = new BilPugSolution();
        }
        ```

        * This inner class is loaded **lazily**, **only once**, **when first accessed**.
        * Java's **class loading** is thread-safe by the **JVM specification**.
        * So even if **1000 threads** call `getInstance()` at the same time, the **class will only be loaded and initialized once**, and only **one instance** of `BilPugSolution` will be created.

        ---

        ### ✅ Example:

        ```java
        BilPugSolution instance1 = BilPugSolution.getInstance();
        BilPugSolution instance2 = BilPugSolution.getInstance();

        System.out.println(instance1 == instance2); // true
        ```

        Even if called from different classes, packages, or threads — they all return the **same instance**.

        ### ⚠️ Just make sure:

        * `getInstance()` is `static`
        * The constructor of `BilPugSolution` is **private** to prevent outside instantiation
        * You don't manually create instances somewhere else
    *
    * */

    //

    private BilPugSolution() {}


    // Nested class does not load during class loading
    // So when getInstance is being called then only it is called and creates the instance of BilPugSolution is being created
    private static class DbConnectionHelper {
        private static final BilPugSolution INSTANCE = new BilPugSolution();
    }

    public static BilPugSolution getInstance() {
        return DbConnectionHelper.INSTANCE;
    }
}
