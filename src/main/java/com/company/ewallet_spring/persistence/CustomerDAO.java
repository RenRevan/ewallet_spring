package com.company.ewallet_spring.persistence;

import com.company.ewallet_spring.persistence.entities.Customer;

import java.util.Optional;

public interface CustomerDAO extends DAO<Customer>{
    Customer findByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);
}
