package com.company.ewallet_spring.persistence.repositories;

import com.company.ewallet_spring.persistence.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Wallet findByCustomerId(int customerId);
}
