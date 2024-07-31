package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.AccountDAO;
import com.company.ewallet_spring.persistence.entities.Account;
import com.company.ewallet_spring.persistence.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AccountImpl implements AccountDAO {

    private final AccountRepository accountRepository;

    @Override
    public Account create(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public Account get(int id) {
        return accountRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> findAllByWalletId(int walletId) {
        return accountRepository.findAllByWalletId(walletId);
    }

    @Override
    public List<Account> findAllByIbanAndWalletId(String iban, int walletId) {
        return accountRepository.findAllByIbanAndWalletId(iban, walletId);
    }
}
