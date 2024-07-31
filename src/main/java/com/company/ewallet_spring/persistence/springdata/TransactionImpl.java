package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.TransactionDAO;
import com.company.ewallet_spring.persistence.entities.Transaction;
import com.company.ewallet_spring.persistence.repositories.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class TransactionImpl implements TransactionDAO {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }

    @Override
    public Transaction get(int id) {
        return transactionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
}
