package Solid.Liskov;

public class LiskovSubstitution {

}

/*
🚫 2. Common Violations
❌ Example: Bird - Ostrich Problem]
 */
class Bird {
    void fly() {
        System.out.println("Flying");
    }
}

class Ostrich extends Bird {
    @Override
    void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}

// Problem: Ostrich violates LSP — you can’t safely substitute it for Bird.

