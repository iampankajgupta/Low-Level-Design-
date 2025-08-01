package LLD.TransactionFilteringSystem;

import LLD.TransactionFilteringSystem.FilterParse.FilterParseFactory;
import LLD.TransactionFilteringSystem.FilterParse.FilterParser;
import LLD.TransactionFilteringSystem.OperatorType.OperatorType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

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
        Transaction transaction4 = new Transaction(100.0, "Shopping", 6L, 2L, TransactionStatus.COMPLETED, PaymentMethod.CREDIT, LocalDateTime.now());


        transactions.addAll(Arrays.asList(transaction1, transaction2, transaction3,transaction4));




        // Filter the transaction based on the filterCriteria List


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

        filterCriteriaList.add(descriptionFilterCriteria);

        List<Transaction> filteredTransactions = transactions;
        List<Predicate<Transaction>> predicates = new ArrayList<>();

        for (FilterCriteria filterCriteria : filterCriteriaList) {
            String field = filterCriteria.getField();
            String value = filterCriteria.getValue();
            String operator = filterCriteria.getOperatorType();

            List<String> list = Arrays.stream(value.split(",")).toList();
            if(list.size() != 1) {
                List<Predicate<Transaction>> orPredicates = new ArrayList<>();
                transactions.stream().filter(predicates.stream().reduce(x -> false, Predicate::or));
            }

            // Get the field type
            Class<?> fieldType = FieldRegistry.FIELD_TYPE_EXTRACTORS.get(field);
            Operator operator1 = Operator.valueOf(operator);

            // Dynamically resolve operatorType, parser, and extractor
            OperatorType<?> operatorType = OperatorTypeFactory.getOperatorType(fieldType, operator1);
            FilterParser<?> parser = FilterParseFactory.getFilterParse(fieldType, value);
            Object parsedValue = parser.parse(value);
            Function<Transaction, ?> extractor = FieldRegistry.FIELD_EXTRACTORS.get(field);

            // 🔥 Unsafe cast, but necessary due to Java's generic type erasure
            @SuppressWarnings("unchecked")
            Predicate<Transaction> predicate = ((OperatorType<Object>) operatorType)
                    .apply((Function<Transaction, Object>) extractor, parsedValue);

            predicates.add(predicate);
        }

        // Combine all predicates with AND
        // this will only work and operator

        Predicate<Transaction> combined = predicates.stream().reduce(x -> true, Predicate::and);

        // for every field multiple values can be passed, instead of single

        // Status -> PENDING, APPROVED, COMPLETED





        filteredTransactions = transactions.stream().filter(combined).toList();

        for(Transaction transaction : filteredTransactions) {
            System.out.println(transaction);
        }

    }
}
