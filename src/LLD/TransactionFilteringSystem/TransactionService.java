package LLD.TransactionFilteringSystem;

import LLD.TransactionFilteringSystem.Exceptions.TransactionValidationException;
import LLD.TransactionFilteringSystem.enums.ValidationErrorType;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionService {
    // to handle concurrency
    private ConcurrentLinkedQueue<Transaction> transactions;

    public TransactionService(ConcurrentLinkedQueue<Transaction> transactions) {
        this.transactions = transactions;
    }


    public List<Transaction> getFilteredTransaction(long amount, String description, long customerId, long merchantId, TransactionStatus status, PaymentMethod paymentMethod){
        // Validate Transaction

        Stream<Transaction> transactionStream = transactions.stream();
        if(customerId != 0 ) {
            transactionStream = transactionStream.filter(transaction -> transaction.getCustomerId() == customerId);
            return transactionStream.toList();
        }
        if (amount > 0) {
            transactionStream = transactionStream.filter(transaction -> transaction.getAmount() >= amount);
        }
        if(merchantId > 0) {
            transactionStream = transactionStream.filter(transaction -> transaction.getMerchantId() == merchantId);
        }
        if(status != null) {
            transactionStream = transactionStream.filter(transaction -> transaction.getStatus().equals(status));
        }

        if(paymentMethod != null) {
            transactionStream = transactionStream.filter(transaction -> transaction.getPaymentMethod().equals(paymentMethod));
        }
        if(description != null) {
            transactionStream = transactionStream.filter(transaction -> transaction.getDescription().contains(description));
        }
        return transactionStream.toList();
    }

    /*

    public List<Transaction> getFilteredTransaction(OptimiseTransaction optimiseTransaction){
        // Validate Transaction

        Collection<Transaction> transactionList = new ArrayList<>();
        transactionList = transactions;

        if(!optimiseTransaction.getTransactionStatus().equals(null)) {
            transactionList = transactionList.stream().filter(f -> f.getStatus().equals(optimiseTransaction.getTransactionStatus().getField())).collect(Collectors.toList());
        }
        if(optimiseTransaction.getLocalDateTimePair().equals(null)) {
            transactionList = getFilteredByOperatorDateTime(optimiseTransaction.getLocalDateTimePair().getField(), optimiseTransaction.getLocalDateTimePair().getOperator(), transactionList);
        }

        if(!optimiseTransaction.getDescription().equals(null)) {
            transactionList = getFilteredByOperatorString(optimiseTransaction.getDescription().getField(), optimiseTransaction.getDescription().getOperator(), transactionList.stream().toList());
        }
        if(!optimiseTransaction.getAmount().getField().equals(0)) {
            transactionList = getFilteredByOperatorInteger(optimiseTransaction.getAmount().getField(), optimiseTransaction.getAmount().getOperator(), transactionList.stream().toList());
        }
        if(optimiseTransaction.getMerchantId().equals(null)) {

        }

        if(optimiseTransaction.getLocalDateTimePair().equals(null)) {

        }
        return transactionList.stream().toList();

    }


     */

    // Optimise way
    private  <T extends Comparable<T>> List<Transaction> getFilteredByOperator(Collection<Transaction> list, T field, String operator, Function<Transaction, T> fieldExtractor) {

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
        return list.stream().filter(predicate).collect(Collectors.toList());
    }


    // Single Responsibility
    // Open close principle
    // Being Violated
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


    /*
    private Collection<Transaction> getFilteredByOperatorInteger(Double field, String operator, Collection<Transaction> list) {
        switch (Operator.valueOf(operator)) {
            case EQUALS :
                list = list.stream().filter(transaction -> transaction.getAmount() == field).collect(Collectors.toList());
                break;
            case GREATER_THAN:
                list = list.stream().filter(transaction -> transaction.getAmount() > field).collect(Collectors.toList());
                break;
            case GREATER_THAN_EQUAL_TO:
                list = list.stream().filter(transaction -> transaction.getAmount() >= field).collect(Collectors.toList());
                break;
            case LESS_THAN:
                list = list.stream().filter(transaction -> transaction.getAmount() < field).collect(Collectors.toList());
                break;
            case LESS_THAN_EQUAL_TO:
                list = list.stream().filter(transaction -> transaction.getAmount() < field).collect(Collectors.toList());
                break;
        }
        return list.stream().toList();
    }
    */




    /*  // Optimised this method below
    public List<Transaction> getFilteredByOperatorString(String field, String operator, List<Transaction> transactionList, boolean firstTimeFilterHappened) {
        switch (Operator.valueOf(operator)) {
            case CONTAINS:
                if(firstTimeFilterHappened) {
                    transactionList =  transactionList.stream().filter(transaction -> transaction.getDescription().contains(field)).collect(Collectors.toList());
                }else {
                    transactionList =  transactions.stream().filter(transaction -> transaction.getDescription().contains(field)).collect(Collectors.toList());
                }
                return transactionList;
            default:
                throw new IllegalArgumentException("");
        }
    }
     */


    public List<Transaction> getFilteredByOperatorString(String field, String operator, Collection<Transaction> transactionList) {
        switch (Operator.valueOf(operator)) {
            case CONTAINS:
                transactionList = transactionList.stream().filter(f -> f.getDescription().contains(field)).toList();
                break;
            default:
                throw new IllegalArgumentException("");
        }
        return transactionList.stream().toList();
    }

    // This is also optimised
    public List<Transaction> getFilteredByOperatorDateTime(LocalDateTime localDateTime, String operator, Collection<Transaction> transactionList) {
;

        switch (Operator.valueOf(operator)) {
            case AFTER:
                transactionList = transactionList.stream().filter(f -> f.getTransactionDateTime().isAfter(localDateTime)).collect(Collectors.toList());
                break;
            case BEFORE:
                transactionList = transactionList.stream().filter(f -> f.getTransactionDateTime().isBefore(localDateTime)).collect(Collectors.toList());
                break;
            case EQUALS:
                transactionList = transactionList.stream().filter(f -> f.getTransactionDateTime().equals(localDateTime)).collect(Collectors.toList());
                break;
            default:
               throw new IllegalArgumentException("Invalid Operator");
        }
        return transactionList.stream().toList();
    }


    public Transaction addTransaction(Double amount, String description, long customerId, long merchantId, TransactionStatus status, PaymentMethod paymentMethod) {
        // Validate transaction fields

        /*
        ✅ Why This is Ideal for LLD Interviews
        Aspect	Why It’s Good
        DRY	Avoids repeating boilerplate code
        Extensible	Easy to add more validation types later
        SOLID Principles	Follows OCP and SRP
        Interview-Friendly	Shows strong design thinking
        Production-Ready	Aligns with real-world microservices/API

        ❓Bonus: What If You Want Granular Exception Types Later?
        You can still extend the main one:

        public class InvalidPaymentMethodException extends TransactionValidationException {
            public InvalidPaymentMethodException(String message) {
                super(ValidationErrorType.INVALID_PAYMENT_METHOD, message);
            }
        }
        But only do this if truly needed, like when you must catch this specific type somewhere.
        */


        // Following DRY Principle
        // created a enum of exception type and create a custom exception class there passing all as the constants
        if(amount <= 0) throw new TransactionValidationException("Amount is invalid", ValidationErrorType.INVALID_AMOUNT_EXCEPTION);
        if(description.isEmpty()) throw new TransactionValidationException("Description is invalid", ValidationErrorType.INVALID_DESCRIPTION_EXCEPTION);
        if(customerId <= 0) throw new TransactionValidationException("CustomId is invalid should be greater than zero", ValidationErrorType.CUSTOMER_ID_INVALID_EXCEPTION);
        if(merchantId <= 0) throw new TransactionValidationException("CustomId is invalid should be greater than zero", ValidationErrorType.MERCHANT_ID_EXCEPTION);
        if(status == null) throw new TransactionValidationException("CustomId is invalid should be greater than zero", ValidationErrorType.PAYMENT_STATUS_INVALID);
        if(paymentMethod == null) throw new TransactionValidationException("Payment Method is not valid", ValidationErrorType.INVALID_PAYMENT_METHOD_EXCEPTION);
        Transaction transaction = new Transaction(amount, description, customerId, merchantId, status, paymentMethod, LocalDateTime.now());
        transactions.add(transaction);
        return transaction;
    }

    // update transaction
    // delete transaction



}
