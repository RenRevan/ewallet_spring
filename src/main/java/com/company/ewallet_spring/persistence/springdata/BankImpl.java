package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.BankDAO;
import com.company.ewallet_spring.persistence.entities.Bank;
import com.company.ewallet_spring.persistence.repositories.BankRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BankImpl implements BankDAO {

    private final BankRepository bankRepository;

    @Override
    public Bank create(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank update(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public void delete(Bank bank) {
        bankRepository.delete(bank);
    }

    @Override
    public Bank get(int id) {
        return bankRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }
}
