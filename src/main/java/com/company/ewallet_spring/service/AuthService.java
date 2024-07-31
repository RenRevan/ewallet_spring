package com.company.ewallet_spring.service;

import com.company.ewallet_spring.dto.RegistrationRequest;
import com.company.ewallet_spring.dto.RegistrationResponse;
import com.company.ewallet_spring.persistence.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface AuthService {

    Customer login(String email, String password);
    List<Customer> allCustomers();
    RegistrationResponse registration(RegistrationRequest request);
}
