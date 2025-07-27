package LLD.TransactionFilteringSystem.OperatorType;

import LLD.TransactionFilteringSystem.Transaction;

import java.util.function.Function;

public class EqualOperatorType<T> implements OperatorType<T> {
    @Override
    public boolean apply(Function<Transaction, T> transaction, T t) {
        return transaction.apply(transaction)
    }

    // current Doubt

}
