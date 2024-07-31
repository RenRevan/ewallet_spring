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
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "mobile_number", nullable = false, length = 12)
    private String mobileNumber;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_role_id", nullable = false)
    private CustomerRole customerRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(mobileNumber, customer.mobileNumber) && Objects.equals(email, customer.email) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(password, customer.password) && Objects.equals(customerRole, customer.customerRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mobileNumber, email, firstName, lastName, password, customerRole);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", mobileNumber=" + mobileNumber +
                ", email=" + email +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", password=" + password +
                ", customerRole=" + customerRole +
                '}';
    }
}