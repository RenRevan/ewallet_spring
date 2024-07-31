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
@Table(name = "operation_code")
public class OperationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", length = 45)
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationCode that = (OperationCode) o;
        return Objects.equals(id, that.id) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }

    @Override
    public String toString() {
        return "OperationCode{" +
                "id=" + id +
                ", code=" + code +
                '}';
    }
}