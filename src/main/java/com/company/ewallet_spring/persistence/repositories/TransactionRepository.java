package com.company.ewallet_spring.persistence.repositories;

import com.company.ewallet_spring.persistence.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
