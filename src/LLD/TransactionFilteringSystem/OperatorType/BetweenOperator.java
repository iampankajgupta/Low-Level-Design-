package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Model.Transaction;

import java.util.function.Function;
import java.util.function.Predicate;

public class BetweenOperator<T extends Comparable<T>>  implements OperatorType2<T> {
    @Override
    public Predicate<Transaction> between(Function<Transaction, T> fieldExtractor, T val1, T val2) {

        // Normalise the bounds
        T lower = val1.compareTo(val2) <=0 ? val1 : val2;
        T upper = val1.compareTo(val2) <=0 ? val2 : val1;

        return transaction -> {
            T value = fieldExtractor.apply(transaction);
            return value.compareTo(lower) >=0 && value.compareTo(upper) <=0;
        };
    }
}
