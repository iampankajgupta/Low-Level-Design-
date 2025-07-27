package Generics;

import com.sun.security.jgss.GSSUtil;

public class Print {
    Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue(){ return value;}


    public static void main(String[] args) {
        Print print = new Print();
        print.setValue(1);
        print.setValue("1");
        print.setValue(1.1);

        // Need to do typecasting before use else will get compilation error
       if((Double)print.getValue() == 1) {
           System.out.println(print.value);
       }
       /*
       if(print.getValue() == 1.1) {

       }*/


    }
}
