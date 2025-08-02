package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Model.Transaction;

import java.util.function.Function;
import java.util.function.Predicate;

public class LessThan<T extends Comparable<T>> implements OperatorType1<T> {

    /*
    * 🔁 How to Remember:
        Think like a subtraction:
        a.compareTo(b) is like doing a - b (conceptually, not actually for all types).

        Result:

        0 → values are equal

        Negative (like -1) → first is smaller

        Positive (like 1) → first is bigger
    *
    *
    * */
    @Override
    public Predicate<Transaction> apply(Function<Transaction, T> fieldExtractor, T fieldValue) {
        return transaction -> fieldExtractor.apply(transaction).compareTo(fieldValue) < 0;
    }
}

