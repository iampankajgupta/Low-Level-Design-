package Generics;

public class GenericPairPrint<K,V> {

    private K key;
    private V value;


    public void put(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }


    public K getKey() {
        return key;
    }


    public static void main(String[] args) {
        GenericPairPrint<Integer, String> genericPairPrint = new GenericPairPrint<>();
        genericPairPrint.put(1,"2");
        genericPairPrint.put(2,"2");
        System.out.println(genericPairPrint.getValue());
    }
}
