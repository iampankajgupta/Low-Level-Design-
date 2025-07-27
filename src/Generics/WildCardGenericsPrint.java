package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WildCardGenericsPrint {

    public void setValue(List<? extends Number> upperBoundsNumbers) {

    }

    public void setLowerBoundNumber(List<? super Number> lowerBoundNumber) {

    }
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(1.1);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);

        // numberList = integers; // this is not allowed because numbersList is of List of SuperType and it contains Integer, Float, Double etc but integers can only int

        // Like we Parent class can contain object of child class
        // Number number = new Integer(1); // this will work but in case of generics it works bit different

        List<? extends Number> numbers = new ArrayList<>(); // Type should be either or below Numbers class like Integer, Double, Float
        // numbers.add(1);

        List<Integer> integerList = new ArrayList<>();
        WildCardGenericsPrint wildCardGenericsPrint = new WildCardGenericsPrint();
        wildCardGenericsPrint.setValue(integerList); // this is allowed because Integer extends Number

        List<String> strings = new ArrayList<>();
       // wildCardGenericsPrint(strings) // this is not allowed this does not extend Number


        // this is not allowed beacause of lowerBound [ ? super Number ] -> Type should be either or upper than Number class i.e Object class
        // wildCardGenericsPrint.setLowerBoundNumber(integerList);

        // this is allowed because Parent class of any class Object only
        List<Object> objects = new ArrayList<>();
        wildCardGenericsPrint.setLowerBoundNumber(objects);


        // Unbounded wildcard <?> only you can read






    }
}
