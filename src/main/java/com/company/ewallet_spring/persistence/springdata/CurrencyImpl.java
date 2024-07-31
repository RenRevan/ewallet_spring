package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.CurrencyDAO;
import com.company.ewallet_spring.persistence.entities.Currency;
import com.company.ewallet_spring.persistence.repositories.CurrencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CurrencyImpl implements CurrencyDAO {

    private final CurrencyRepository currencyRepository;

    @Override
    public Currency create(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency update(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public void delete(Currency currency) {
        currencyRepository.delete(currency);
    }

    @Override
    public Currency get(int id) {
        return currencyRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }
}
