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
@Table(name = "customer_role")
public class CustomerRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "role", length = 45)
    private String role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerRole that = (CustomerRole) o;
        return Objects.equals(id, that.id) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    @Override
    public String toString() {
        return "CustomerRole{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}