package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Transaction;

import java.util.function.Function;
import java.util.function.Predicate;

public class StringContainsOperator implements OperatorType<String>{
    @Override
    public Predicate<Transaction> apply(Function<Transaction, String> fieldExtractor, String fieldValue) {
        return transaction -> fieldExtractor.apply(transaction).contains(fieldValue);
    }
}
