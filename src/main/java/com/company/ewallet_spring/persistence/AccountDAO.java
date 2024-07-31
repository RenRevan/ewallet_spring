package com.company.ewallet_spring.persistence;

import com.company.ewallet_spring.persistence.entities.Account;

import java.util.List;

public interface AccountDAO extends DAO<Account> {
    List<Account> findAllByWalletId(int walletId);
    List<Account> findAllByIbanAndWalletId(String iban, int walletId);
}
