package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Transaction;

import java.time.LocalDateTime;
import java.util.function.Function;
import java.util.function.Predicate;

public class GreaterThanOperator<T extends Comparable<T>> implements OperatorType<T>{
    @Override
    public Predicate<Transaction> apply(Function<Transaction, T> fieldExtractor, T fieldValue) {
        return transaction -> fieldExtractor.apply(transaction).compareTo(fieldValue) > 0;
    }

    public static class LocalDateEqualOperatorType implements OperatorType<LocalDateTime> {
        @Override
        public Predicate<Transaction> apply(Function<Transaction, LocalDateTime> fieldExtractor, LocalDateTime fieldValue) {
            return transaction -> fieldExtractor.apply(transaction).equals(fieldValue);
        }
    }
}
