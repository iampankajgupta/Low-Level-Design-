package LLD.TransactionFilteringSystem;

import LLD.TransactionFilteringSystem.OperatorType.OperatorType;

import java.util.function.Function;
import java.util.function.Predicate;

public class Between<T extends Comparable<T>>  implements OperatorType<T> {
    @Override
    public Predicate<Transaction> apply(Function<Transaction, T> fieldExtractor, T fieldValue) {
        return transaction -> fieldExtractor.apply(transaction).compareTo(fieldValue) == 0;
    }
}
