package Recursion;

public class Test2 {
    public static void main(String[] args) {


        String str = "Hello";
        swap(str);
        System.out.println(str);
    }

    private static void swap(String str) {
        str = "World";
    }

    public static void swap(Integer a, Integer b){
        int temp = a;
        a = b;
        b = temp;
    }
}

