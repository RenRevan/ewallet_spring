package com.company.ewallet_spring.service.impl;

import com.company.ewallet_spring.dto.TransactionRequest;
import com.company.ewallet_spring.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    @Override
    public void createTransaction(TransactionRequest request) {

    }

    @Override
    public void transactionsHistoryByIban(String iban) {

    }
}
