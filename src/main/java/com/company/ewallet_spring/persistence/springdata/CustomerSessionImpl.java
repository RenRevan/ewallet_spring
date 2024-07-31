package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.CustomerSessionDAO;
import com.company.ewallet_spring.persistence.entities.CustomerSession;
import com.company.ewallet_spring.persistence.repositories.CustomerSessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class CustomerSessionImpl implements CustomerSessionDAO {

    private final CustomerSessionRepository customerSessionRepository;

    @Override
    public CustomerSession create(CustomerSession customerSession) {
        return customerSessionRepository.save(customerSession);
    }

    @Override
    public CustomerSession update(CustomerSession customerSession) {
        return customerSessionRepository.save(customerSession);
    }

    @Override
    public void delete(CustomerSession customerSession) {
        customerSessionRepository.delete(customerSession);
    }

    @Override
    public CustomerSession get(int id) {
        return customerSessionRepository.findById(id).orElseThrow();
    }

    @Override
    public List<CustomerSession> getAll() {
        return customerSessionRepository.findAll();
    }
}
