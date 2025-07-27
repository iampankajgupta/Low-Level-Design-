package Generics;

public class GenericPrint2<T>{
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        GenericPrint2<Integer> print2 = new GenericPrint2();
        print2.setValue(1);
       // print2.setValue("123"); // if other type will be used will get compilation error
        //print2.setValue(1.1); // if other type will be used will get compilation error


        // this will be possible still, but still while using need to do typecasting
        GenericPrint2 genericPrint2 = new GenericPrint2();
        genericPrint2.setValue(1);
        genericPrint2.setValue("1");

        if((Integer)genericPrint2.getValue() == 1){

        }
    }
}
