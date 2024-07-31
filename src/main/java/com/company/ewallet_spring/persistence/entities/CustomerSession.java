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
@Table(name = "customer_session")
public class CustomerSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "session_datetime")
    private Instant sessionDatetime;

    @Column(name = "browser", length = 45)
    private String browser;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (CustomerSession) o;
        return Objects.equals(id, that.id) && Objects.equals(sessionDatetime, that.sessionDatetime) && Objects.equals(browser, that.browser) && Objects.equals(customer, that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionDatetime, browser, customer);
    }

    @Override
    public String toString() {
        return "CustomerSession{" +
                "id=" + id +
                ", sessionDatetime=" + sessionDatetime +
                ", browser=" + browser +
                ", customer=" + customer +
                '}';
    }
}