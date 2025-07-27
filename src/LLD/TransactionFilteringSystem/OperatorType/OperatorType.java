package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Transaction;

public interface OperatorType<T> {
    // They all will be of type predicate

    boolean apply(Transaction transaction, T t );
}
