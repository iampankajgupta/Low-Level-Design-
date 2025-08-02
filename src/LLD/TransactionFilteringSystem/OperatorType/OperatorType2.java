package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Model.Transaction;

import java.util.function.Function;
import java.util.function.Predicate;

public interface OperatorType2<T> extends OperatorMain<T>{
    Predicate<Transaction> between(Function<Transaction, T> fieldExtractor, T val1, T val2);
}
