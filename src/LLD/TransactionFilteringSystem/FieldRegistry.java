package LLD.TransactionFilteringSystem;

import LLD.TransactionFilteringSystem.Model.Transaction;
import LLD.TransactionFilteringSystem.enums.PaymentMethod;
import LLD.TransactionFilteringSystem.enums.TransactionStatus;

import java.util.Map;
import java.util.function.Function;

public class FieldRegistry {

    public static final Map<String, Function<Transaction, ? >> FIELD_EXTRACTORS = Map.of(
            "status", Transaction::getStatus,
            "amount", Transaction:: getAmount,
            "customerId", Transaction::getCustomerId,
            "merchantId", Transaction::getMerchantId,
            "description", Transaction::getDescription,
            "paymentMethod", Transaction::getPaymentMethod
    );


    public static final Map<String, Class<?>> FIELD_TYPE_EXTRACTORS = Map.of(
            "status", TransactionStatus.class,
            "paymentMethod", PaymentMethod.class,
            "amount", Double.class,
            "customerId", Long.class,
            "merchantId", Long.class,
            "description", String.class
    );

}
