package com.company.ewallet_spring.persistence.entities;

import lombok.*;

import jakarta.persistence.*;

import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(id, wallet.id) && Objects.equals(customer, wallet.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", customer=" + customer +
                '}';
    }
}