package com.company.ewallet_spring.persistence.entities;

import lombok.*;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "date", nullable = false)
    private Instant date;

    @Column(name = "description", length = 225)
    private String description;

    @Column(name = "iban_from", nullable = false, length = 45)
    private String ibanFrom;

    @Column(name = "iban_to", nullable = false, length = 45)
    private String ibanTo;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "operation_code_id", nullable = false)
    private OperationCode operationCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && Objects.equals(date, that.date) && Objects.equals(description, that.description) && Objects.equals(ibanFrom, that.ibanFrom) && Objects.equals(ibanTo, that.ibanTo) && Objects.equals(account, that.account) && Objects.equals(operationCode, that.operationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, date, description, ibanFrom, ibanTo, account, operationCode);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", date=" + date +
                ", description=" + description +
                ", ibanFrom=" + ibanFrom +
                ", ibanTo=" + ibanTo +
                ", account=" + account +
                ", operationCode=" + operationCode +
                '}';
    }
}