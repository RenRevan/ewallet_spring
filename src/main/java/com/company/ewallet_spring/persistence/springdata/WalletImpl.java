package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.WalletDAO;
import com.company.ewallet_spring.persistence.entities.Wallet;
import com.company.ewallet_spring.persistence.repositories.WalletRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class WalletImpl implements WalletDAO {

    private final WalletRepository walletRepository;

    @Override
    public Wallet create(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet update(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void delete(Wallet wallet) {
        walletRepository.delete(wallet);
    }

    @Override
    public Wallet get(int id) {
        return walletRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Wallet> getAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet findByCustomerId(int customerId) {
        return walletRepository.findByCustomerId(customerId);
    }
}
