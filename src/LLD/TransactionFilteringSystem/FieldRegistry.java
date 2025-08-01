package LLD.TransactionFilteringSystem;

import java.util.Map;
import java.util.function.Function;

public class FieldRegistry {

    public static final Map<String, Function<Transaction, ? >> FIELD_EXTRACTORS = Map.of(
            "status", Transaction::getStatus,
            "amount", Transaction:: getAmount,
            "customerId", Transaction::getCustomerId,
            "merchantId", Transaction::getMerchantId,
            "description", Transaction::getDescription
    );


    public static final Map<String, Class<?>> FIELD_TYPE_EXTRACTORS = Map.of(
            "status", TransactionStatus.class,
            "amount", Double.class,
            "customerId", Long.class,
            "merchantId", Long.class,
            "description", String.class
    );

}
