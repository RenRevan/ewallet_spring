package com.company.ewallet_spring.persistence;

import com.company.ewallet_spring.persistence.entities.Wallet;

public interface WalletDAO extends DAO<Wallet> {
    Wallet findByCustomerId(int customerId);
}
