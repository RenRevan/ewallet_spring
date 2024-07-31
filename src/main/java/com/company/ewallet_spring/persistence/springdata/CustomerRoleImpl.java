package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.CustomerDAO;
import com.company.ewallet_spring.persistence.CustomerRoleDAO;
import com.company.ewallet_spring.persistence.entities.Customer;
import com.company.ewallet_spring.persistence.entities.CustomerRole;
import com.company.ewallet_spring.persistence.repositories.CustomerRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CustomerRoleImpl implements CustomerRoleDAO {

    private final CustomerRoleRepository customerRoleRepository;

    @Override
    public CustomerRole create(CustomerRole customerRole) {
        return customerRoleRepository.save(customerRole);
    }

    @Override
    public CustomerRole update(CustomerRole customerRole) {
        return customerRoleRepository.save(customerRole);
    }

    @Override
    public void delete(CustomerRole customerRole) {
        customerRoleRepository.delete(customerRole);
    }

    @Override
    public CustomerRole get(int id) {
        return customerRoleRepository.findById(id).orElseThrow();
    }

    @Override
    public List<CustomerRole> getAll() {
        return customerRoleRepository.findAll();
    }
}
