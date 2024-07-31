package com.company.ewallet_spring.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "iban", nullable = false, length = 45)
    private String iban;

    @Column(name = "balance")
    private Integer balance;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(iban, account.iban) && Objects.equals(balance, account.balance) && Objects.equals(wallet, account.wallet) && Objects.equals(bank, account.bank) && Objects.equals(currency, account.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban, balance, wallet, bank, currency);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", iban=" + iban +
                ", balance=" + balance +
                ", wallet=" + wallet +
                ", bank=" + bank +
                ", currency=" + currency +
                '}';
    }
}