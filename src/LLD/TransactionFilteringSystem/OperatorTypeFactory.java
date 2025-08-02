package LLD.TransactionFilteringSystem;

import LLD.TransactionFilteringSystem.OperatorType.*;
import LLD.TransactionFilteringSystem.enums.Operator;
import LLD.TransactionFilteringSystem.enums.PaymentMethod;

import java.time.LocalDate;

public class OperatorTypeFactory {

    // Common for String, Date, Integer, Long

 //   public static ParentOperator<T> getOperatorType(T field, String operator) {
       // Field type is string but operator type

        /// Invalid combination
        // String with grtThan, LessThan, grtThanEqualTo, lessThanEqualTo, after, before
        // Integer with contain. startsWith, EndsWith, after, before not allowed
        // Date contains, LessThan, grtThanEqualTo, lessThanEqualTo,  startsWith, EndsWith, after, before not allowed
        /*
        *         ParentOperator<T>
                NumberOperrator<T extends Comparable<Number>> extends ParentOperator
                StringOperator extends ParentOpweraot<String>

        * */

        /*
        if(operator.equals(Operator.EQUALS)) {
            return new StringEqualOperatorType<T>();
        }else if(operator.equals(Operator.GREATER_THAN)) {
            return new GreaterThanOperator<T>();
        }else if(operator.equals(Operator.LESS_THAN)) {
            return new LessThan<T>();
        }else {
            throw new IllegalArgumentException("No Operator Matches");
        }
        }
         */

    public static <T> OperatorMain<T> getOperatorType(Class<T> fieldType, Operator operatorType) {
        if(fieldType == String.class || fieldType == PaymentMethod.class) {
            return getStringOperatorType(operatorType);
        }else if(Number.class.isAssignableFrom(fieldType)) {
            return (OperatorType1<T>) getNumberOperatorType(operatorType);
        }else if(fieldType == LocalDate.class) {
            return getLocalDateOperatorType(operatorType);
        }
        else {
            throw new IllegalArgumentException("Field Type or OperatorType are incompatible");
        }
    }

    private static <T> OperatorMain<T> getLocalDateOperatorType(Operator operatorType) {
        return switch (operatorType) {
            case EQUALS -> (OperatorType1<T>) new GreaterThanOperator.LocalDateEqualOperatorType();
           // case AFTER -> new GreaterThanOperator<>();
            //case BEFORE -> new LessThan<>();
            default -> throw new IllegalArgumentException();
        };
        // throw new IllegalArgumentException("Illegal Operator Type");
    }

    // this is syntax of generics used with method
    private static <T extends Comparable<T>> OperatorMain<T> getNumberOperatorType(Operator operatorType) {;
        try {
            return switch (operatorType) {
                case EQUALS ->  new NumberEqualOperator<>();
                case GREATER_THAN -> new GreaterThanOperator<>();
                case LESS_THAN -> new LessThan<>();
                case BETWEEN -> new BetweenOperator<>();
                default -> throw new IllegalArgumentException();
            };
        }catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private static <T> OperatorMain<T> getStringOperatorType(Operator operatorType) {
        return switch (operatorType) {
            case EQUALS ->  (OperatorType1<T>) new StringEqualOperatorType();
            case CONTAINS -> (OperatorType1<T>) new StringContainsOperator();
            default -> throw new IllegalArgumentException("Illegal Operator Type");
        };
    }
}
