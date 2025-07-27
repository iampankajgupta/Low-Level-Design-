package Generics;

// This is UpperBound Example

public class BoundedGenerics<T extends Number> {

    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        BoundedGenerics<Integer> boundedGenerics = new BoundedGenerics<>();
        boundedGenerics.setValue(1);

        // This is not allowed beacause T should be extending from number
        // BoundedGenerics<String> boundedGenerics1 = new BoundedGenerics<String>();
    }
}
