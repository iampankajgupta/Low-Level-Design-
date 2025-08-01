package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Transaction;

import java.util.function.Function;
import java.util.function.Predicate;

public class NumberEqualOperator<T extends Comparable<T>> implements OperatorType<T>{
    @Override
    public Predicate<Transaction> apply(Function<Transaction, T> fieldExtractor, T fieldValue) {
        return transaction -> fieldExtractor.apply(transaction).compareTo(fieldValue) == 0;
    }
}
