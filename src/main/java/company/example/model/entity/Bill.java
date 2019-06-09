package company.example.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long amountDue;
    private String bankAccountNumber;
    private Instant creationTime;
    private String paymentTransactionId;

    public Bill() {
    }

    public Bill(long amountDue, String bankAccountNumber, String paymentTransactionId) {
        this.amountDue = amountDue;
        this.bankAccountNumber = bankAccountNumber;
        this.paymentTransactionId = paymentTransactionId;
        this.creationTime = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(long amountDue) {
        this.amountDue = amountDue;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public String getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }
}
