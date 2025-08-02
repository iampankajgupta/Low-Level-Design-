package LLD.TransactionFilteringSystem;

import LLD.TransactionFilteringSystem.Model.FilterCriteria;
import LLD.TransactionFilteringSystem.Model.Transaction;
import LLD.TransactionFilteringSystem.Service.TransactionService;
import LLD.TransactionFilteringSystem.enums.PaymentMethod;
import LLD.TransactionFilteringSystem.enums.TransactionStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Working as Expected
    // Multiple field is being given then filtering is working with And
    // String Equal Operator and contain is also working
    // If No Filter is being given returns all the transactions.
    public static void main(String[] args) {

        // Create some transactions

        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction1 = new Transaction(1000.0, "Grocery", 1L, 2L, TransactionStatus.COMPLETED, PaymentMethod.CREDIT, LocalDateTime.now());
        Transaction transaction2 = new Transaction(1000.0, "Grocery", 12L, 2L, TransactionStatus.COMPLETED, PaymentMethod.DEBIT, LocalDateTime.now());
        Transaction transaction3 = new Transaction(100.0, "Mall", 20L, 2L, TransactionStatus.COMPLETED, PaymentMethod.UPI, LocalDateTime.now());
        Transaction transaction4 = new Transaction(100.0, "Shoppingery", 6L, 2L, TransactionStatus.COMPLETED, PaymentMethod.CREDIT, LocalDateTime.now());

        // List of filterCriteria


        transactions.addAll(Arrays.asList(transaction1, transaction2, transaction3,transaction4));

        List<FilterCriteria<?>> filterCriteriaList = new ArrayList<>();
        /*
        // Creating the filterCriteria
        FilterCriteria<Long> amountFilterCriteria= new FilterCriteria<Long>();
        amountFilterCriteria.setField("amount");;
        amountFilterCriteria.setValue("1000");

        amountFilterCriteria.setOperatorType(Operator.EQUALS.toString());
        // will needing a factory pattern

        amountFilterCriteria.setOperatorType(Operator.EQUALS.toString());

        // Creating the filterCriteria
        FilterCriteria<Integer> customerIdFilterCriteria= new FilterCriteria<Integer>();
        customerIdFilterCriteria.setField("customerId");
        customerIdFilterCriteria.setValue("1");
        customerIdFilterCriteria.setOperatorType("EQUALS");

        // Creating the filterCriteria

        FilterCriteria<Integer> merchantIdFilterCriteria= new FilterCriteria<Integer>();
        merchantIdFilterCriteria.setField("merchantId");
        merchantIdFilterCriteria.setValue("2");
        merchantIdFilterCriteria.setOperatorType("EQUALS");

        filterCriteriaList.add(amountFilterCriteria);
        filterCriteriaList.add(customerIdFilterCriteria);
        filterCriteriaList.add(merchantIdFilterCriteria);

         */

        // Check if the value is comma separated
        // Create OR Predicates of those




        FilterCriteria<String> descriptionFilterCriteria= new FilterCriteria();
        descriptionFilterCriteria.setField("description");
        descriptionFilterCriteria.setValue("ery");
        descriptionFilterCriteria.setOperatorType("CONTAINS");


        FilterCriteria<String> paymentMethodFilterCriteria = new FilterCriteria<>();
        paymentMethodFilterCriteria.setField("paymentMethod");
        paymentMethodFilterCriteria.setValue("CREDIT,UPI");
        paymentMethodFilterCriteria.setOperatorType("EQUALS");
        filterCriteriaList.add(paymentMethodFilterCriteria);
        filterCriteriaList.add(descriptionFilterCriteria);


        TransactionService transactionService = new TransactionService(transactions);
        //transactionService.setTransactions(transactions);
        List<Transaction> filteredTransactions = transactionService.getFilteredTransaction(filterCriteriaList);


        for(Transaction transaction : filteredTransactions) {
            System.out.println(transaction);
        }

    }
}
