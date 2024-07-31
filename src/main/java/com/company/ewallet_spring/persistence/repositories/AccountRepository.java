package com.company.ewallet_spring.persistence.repositories;

import com.company.ewallet_spring.persistence.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findAllByWalletId(int id);
    List<Account> findAllByIbanAndWalletId(String iban, int walletId);
}
