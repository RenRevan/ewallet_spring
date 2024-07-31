package com.company.ewallet_spring.persistence.repositories;

import com.company.ewallet_spring.persistence.entities.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Integer> {
}
