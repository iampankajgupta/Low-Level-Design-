package LLD.TransactionFilteringSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


// This violates SOLID Dependency Principle
public class UpdatedTransactionService {

    private ConcurrentLinkedQueue<Transaction> concurrentLinkedQueue;
    // ✅ Ideal DIP-compliant code:
    private Collection<Transaction> transactions;

    public UpdatedTransactionService() {
        this.transactions = new ConcurrentLinkedQueue<>();
    }

    // Optimise way
    private  <T extends Comparable<T>> List<Transaction> getFilteredByOperator(Collection<Transaction> transactions, T field, String operator, Function<Transaction, T> fieldExtractor) {

        Predicate<Transaction> predicate;
        switch (Operator.valueOf(operator)) {
            case EQUALS :
                predicate = txn -> fieldExtractor.apply(txn).compareTo(field) == 0;
                break;
            case GREATER_THAN:
                predicate = txn -> fieldExtractor.apply(txn).compareTo(field) > 0;
                break;
            case GREATER_THAN_EQUAL_TO:
                predicate = txn -> fieldExtractor.apply(txn).compareTo(field) >= 0;
                break;
            case LESS_THAN:
                predicate = txn -> fieldExtractor.apply(txn).compareTo(field) < 0;
                break;
            case LESS_THAN_EQUAL_TO:
                predicate = txn -> fieldExtractor.apply(txn).compareTo(field) <= 0;
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
        return transactions.stream().filter(predicate).collect(Collectors.toList());
    }

    // Switch Statement always violates Open Closed Principle
    public List<Transaction> filterByStringField(
            Collection<Transaction> transactions,
            String value,
            Operator operator,
            Function<Transaction, String> fieldExtractor
    ) {
        Predicate<Transaction> predicate;

        switch (operator) {
            case EQUALS:
                predicate = txn -> fieldExtractor.apply(txn).equals(value);
                break;
            case CONTAINS:
                predicate = txn -> fieldExtractor.apply(txn).contains(value);
                break;
            case STARTS_WITH:
                predicate = txn -> fieldExtractor.apply(txn).startsWith(value);
                break;
            case ENDS_WITH:
                predicate = txn -> fieldExtractor.apply(txn).endsWith(value);
                break;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }

        return transactions.stream().filter(predicate).collect(Collectors.toList());
    }


    // This is also optimised
    public List<Transaction> getFilteredByOperatorDateTime(LocalDateTime localDateTime, String operator, Collection<Transaction> transactions) {
        switch (Operator.valueOf(operator)) {
            case AFTER:
                transactions = transactions.stream().filter(f -> f.getTransactionDateTime().isAfter(localDateTime)).collect(Collectors.toList());
                break;
            case BEFORE:
                transactions = transactions.stream().filter(f -> f.getTransactionDateTime().isBefore(localDateTime)).collect(Collectors.toList());
                break;
            case EQUALS:
                transactions = transactions.stream().filter(f -> f.getTransactionDateTime().equals(localDateTime)).collect(Collectors.toList());
                break;
            default:
                throw new IllegalArgumentException("Invalid Operator");
        }
        return transactions.stream().toList();
    }


    public Transaction addTransaction(Double amount, String description, Long customerId, Long merchantId, TransactionStatus transactionStatus, PaymentMethod paymentMethod, LocalDateTime localDateTime) {
        // LocalDateTime would be current date and time;
        return null;
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction(100.0, "Grocery",1,2,TransactionStatus.COMPLETED, PaymentMethod.CREDIT, localDateTime);
        Transaction transaction2 = new Transaction(100.0, "Market",3,4,TransactionStatus.COMPLETED, PaymentMethod.CREDIT, localDateTime);
        Transaction transaction3 = new Transaction(100.0, "Shopping",1,8,TransactionStatus.COMPLETED, PaymentMethod.CREDIT, localDateTime);
        transactions.addAll(Arrays.asList(transaction1, transaction2, transaction3));
        UpdatedTransactionService transactionService = new UpdatedTransactionService();
        transactionService.addTransaction(100.0, "Grocery",1L,2L,TransactionStatus.COMPLETED, PaymentMethod.CREDIT, localDateTime);

        transactionService.getFilteredByOperatorDateTime()



    }

    /*


    FilterCriteria<T> {
        T field;
        Operator operator
        T value;
    }

   ? known as Unbound wildcard
    List<FilterCriteria<?>>


    public List<Transaction> getFilterTransaction(List<FilterCriteria<?>> filterCriterias) {

    for(FilterCriteria<?> filterCriteria : filterCriteria) {


    }


    }

     */
}
