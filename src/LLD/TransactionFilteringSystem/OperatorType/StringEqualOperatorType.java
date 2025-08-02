package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Model.Transaction;

import java.util.function.Function;
import java.util.function.Predicate;

public class StringEqualOperatorType implements OperatorType1<String> {
    @Override
    public Predicate<Transaction> apply(Function<Transaction, String> fieldExtractor, String fieldValue) {
        return transaction -> fieldExtractor.apply(transaction).toString().equals(fieldValue.toString());
    }
}
