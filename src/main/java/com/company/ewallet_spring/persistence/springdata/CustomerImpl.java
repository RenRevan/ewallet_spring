package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.CustomerDAO;
import com.company.ewallet_spring.persistence.entities.Customer;
import com.company.ewallet_spring.persistence.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CustomerImpl implements CustomerDAO {

    private final CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Customer get(int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Customer findByEmailAndPassword(String email, String password) {
        return customerRepository.findByEmailAndPassword(email, password).orElse(null);
    }
}
