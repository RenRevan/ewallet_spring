package com.company.ewallet_spring.service;

import com.company.ewallet_spring.dto.TransactionRequest;

public interface TransactionService {
    void createTransaction(TransactionRequest request);

    void transactionsHistoryByIban(String iban);

}
