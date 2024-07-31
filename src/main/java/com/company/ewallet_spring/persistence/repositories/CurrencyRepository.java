package com.company.ewallet_spring.persistence.repositories;

import com.company.ewallet_spring.persistence.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
