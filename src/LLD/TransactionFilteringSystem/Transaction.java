package LLD.TransactionFilteringSystem;

import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private final String transactionId;
    private Double amount;
    private String description;
    private long customerId;
    private long merchantId;
    private TransactionStatus status;
    private PaymentMethod paymentMethod;
    private LocalDateTime transactionDateTime;

    public Transaction(Double amount, String description, long customerId, long merchantId, TransactionStatus status, PaymentMethod paymentMethod, LocalDateTime transactionDateTime) {
        this.transactionId = UUID.randomUUID().toString();
        this.amount = amount;
        this.description = description;
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.transactionDateTime = transactionDateTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }
}

