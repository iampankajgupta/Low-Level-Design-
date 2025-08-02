package LLD.TransactionFilteringSystem;

import LLD.TransactionFilteringSystem.Model.Pair;
import LLD.TransactionFilteringSystem.enums.PaymentMethod;
import LLD.TransactionFilteringSystem.enums.TransactionStatus;

import java.time.LocalDateTime;

public class OptimiseTransaction {
    private Pair<Double> amount;;
    private Pair<Integer> merchantId;
    private Pair<String> description;
    private Pair<LocalDateTime> localDateTimePair;
    private Pair<TransactionStatus> transactionStatus;
    private Pair<PaymentMethod> paymentMethod;
    private Pair<Long> customerId;

    public Pair<Double> getAmount() {
        return amount;
    }

    public void setAmount(Pair<Double> amount) {
        this.amount = amount;
    }

    public Pair<Integer> getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Pair<Integer> merchantId) {
        this.merchantId = merchantId;
    }

    public Pair<String> getDescription() {
        return description;
    }

    public void setDescription(Pair<String> description) {
        this.description = description;
    }

    public Pair<LocalDateTime> getLocalDateTimePair() {
        return localDateTimePair;
    }

    public void setLocalDateTimePair(Pair<LocalDateTime> localDateTimePair) {
        this.localDateTimePair = localDateTimePair;
    }

    public Pair<TransactionStatus> getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Pair<TransactionStatus> transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Pair<PaymentMethod> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Pair<PaymentMethod> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Pair<Long> getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Pair<Long> customerId) {
        this.customerId = customerId;
    }
}
