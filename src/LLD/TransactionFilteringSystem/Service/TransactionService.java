package LLD.TransactionFilteringSystem.Service;

import LLD.TransactionFilteringSystem.Exceptions.TransactionValidationException;
import LLD.TransactionFilteringSystem.FieldRegistry;
import LLD.TransactionFilteringSystem.FilterParse.FilterParseFactory;
import LLD.TransactionFilteringSystem.FilterParse.FilterParser;
import LLD.TransactionFilteringSystem.Model.FilterCriteria;
import LLD.TransactionFilteringSystem.Model.Transaction;
import LLD.TransactionFilteringSystem.OperatorType.OperatorMain;
import LLD.TransactionFilteringSystem.OperatorType.OperatorType1;
import LLD.TransactionFilteringSystem.OperatorType.OperatorType2;
import LLD.TransactionFilteringSystem.OperatorTypeFactory;
import LLD.TransactionFilteringSystem.enums.Operator;
import LLD.TransactionFilteringSystem.enums.PaymentMethod;
import LLD.TransactionFilteringSystem.enums.TransactionStatus;
import LLD.TransactionFilteringSystem.enums.ValidationErrorType;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionService {
    // to handle concurrency
    // This actullay violates Dependency Inversion Principle cause it directly depends on Concrete Implementation instead Abstraction
    // private ConcurrentLinkedQueue<Transaction> transactions;

    private final Collection<Transaction> transactions;

    public TransactionService(Collection<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getFilteredTransaction(List<FilterCriteria<?>> filterCriteriaList) {

        // Filter the transaction based on the filterCriteria List

        List<Transaction> filteredTransactions = transactions.stream().toList();
        List<Predicate<Transaction>> predicates = new ArrayList<>();

        for (FilterCriteria filterCriteria : filterCriteriaList) {
            String field = filterCriteria.getField();
            String value = filterCriteria.getValue();
            String operator = filterCriteria.getOperatorType();

            List<String> list = Arrays.stream(value.split(",")).toList();
            Class<?> fieldType = FieldRegistry.FIELD_TYPE_EXTRACTORS.get(field);
            // Parses the String value to Correct format
            FilterParser<?> parser = FilterParseFactory.getFilterParse(fieldType);
            Object parsedValue = parser.parse(value);
            Function<Transaction, ?> extractor = FieldRegistry.FIELD_EXTRACTORS.get(field);
            Operator operator1 = Operator.valueOf(operator);
            // Dynamically resolve operatorType, parser, and extractor
            OperatorMain<?> operatorType = OperatorTypeFactory.getOperatorType(fieldType, operator1);
       /*     if(operator1.equals(Operator.BETWEEN)) {
                // check if that after split getting list of size 2
                // type will be double

                List<Predicate<Transaction>> orPredicates = new ArrayList<>();
                Predicate<Transaction> predicate = ((OperatorType2<Object>) operatorType)
                        .apply((Function<Transaction, Object>) extractor, parser.parse(list.get(0)), parser.parse(list.get(1)));
                predicates.add(predicate);

            }
            *
        */
            if(list.size() > 1) {
                List<Predicate<Transaction>> orPredicates = new ArrayList<>();
                for(String paymentMethod: list) {
                    Predicate<Transaction> predicate = ((OperatorType1<Object>) operatorType)
                            .apply((Function<Transaction, Object>) extractor, paymentMethod);
                    orPredicates.add(predicate);
                }
                predicates.add(orPredicates.stream().reduce(x -> false, Predicate::or));
            }else {
                // 🔥 Unsafe cast, but necessary due to Java's generic type erasure
                @SuppressWarnings("unchecked")
                Predicate<Transaction> predicate = ((OperatorType1<Object>) operatorType)
                        .apply((Function<Transaction, Object>) extractor, parsedValue);

                // Combine all predicates with AND
                // this will only work and operator
                predicates.add(predicates.stream().reduce(x -> true, Predicate::and));

                // for every field multiple values can be passed, instead of single

                // Status -> PENDING, APPROVED, COMPLETED

            }
            filteredTransactions = filteredTransactions.stream().filter(predicates.stream().reduce(x-> true, Predicate::and)).toList();
        }

        return filteredTransactions;
    }

    public Collection<Transaction> getTransactions() {
        return transactions;
    }

    public Collection<Transaction> getAllTransaction() {return transactions;}

    // update transaction
    // delete transaction



}
