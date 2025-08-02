package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Model.Transaction;

import java.util.function.Function;
import java.util.function.Predicate;

public interface OperatorType1<T> extends OperatorMain<T>{
    // They all will be of type predicate

    /*
* 🔁 How to Remember:
    Think like a subtraction:
    a.compareTo(b) is like doing a - b (conceptually, not actually for all types).

    Result:

    0 → values are equal

    Negative (like -1) → first is smaller

    Positive (like 1) → first is bigger
* */
        Predicate<Transaction> apply(Function<Transaction, T> fieldExtractor, T fieldValue);
    }
