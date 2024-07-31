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
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "mfo", length = 45)
    private String mfo;

    @Column(name = "address", length = 45)
    private String address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(id, bank.id) && Objects.equals(name, bank.name) && Objects.equals(mfo, bank.mfo) && Objects.equals(address, bank.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mfo, address);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name=" + name +
                ", mfo=" + mfo +
                ", address=" + address +
                '}';
    }
}