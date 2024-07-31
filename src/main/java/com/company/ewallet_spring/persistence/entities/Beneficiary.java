package com.company.ewallet_spring.persistence.entities;

import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;

//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "beneficiary")
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "iban", length = 45)
    private String iban;

    @Column(name = "bank_name", length = 45)
    private String bankName;

    @Column(name = "mfo")
    private Integer mfo;

    @Column(name = "full_name", length = 45)
    private String fullName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beneficiary that = (Beneficiary) o;
        return Objects.equals(id, that.id) && Objects.equals(iban, that.iban) && Objects.equals(bankName, that.bankName) && Objects.equals(mfo, that.mfo) && Objects.equals(fullName, that.fullName) && Objects.equals(wallet, that.wallet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban, bankName, mfo, fullName, wallet);
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "id=" + id +
                ", iban=" + iban +
                ", bankName=" + bankName +
                ", mfo=" + mfo +
                ", fullName=" + fullName +
                ", wallet=" + wallet +
                '}';
    }
}