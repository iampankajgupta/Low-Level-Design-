package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Model.Transaction;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocalDateIAfterOperatorType implements OperatorType1<LocalDate> {
    @Override
    public Predicate<Transaction> apply(Function<Transaction, LocalDate> fieldExtractor, LocalDate fieldValue) {
        return transaction -> fieldExtractor.apply(transaction).isAfter(fieldValue);
    }
}
