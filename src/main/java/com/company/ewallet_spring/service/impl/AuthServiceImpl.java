package com.company.ewallet_spring.service.impl;

import com.company.ewallet_spring.dto.Error;
import com.company.ewallet_spring.dto.RegistrationRequest;
import com.company.ewallet_spring.dto.RegistrationResponse;
import com.company.ewallet_spring.enums.CustomerRoleTypes;
import com.company.ewallet_spring.persistence.AccountDAO;
import com.company.ewallet_spring.persistence.CustomerDAO;
import com.company.ewallet_spring.persistence.CustomerRoleDAO;
import com.company.ewallet_spring.persistence.WalletDAO;
import com.company.ewallet_spring.persistence.entities.Account;
import com.company.ewallet_spring.persistence.entities.Customer;
import com.company.ewallet_spring.persistence.entities.CustomerRole;
import com.company.ewallet_spring.persistence.entities.Wallet;
import com.company.ewallet_spring.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CustomerDAO customerDAO;
    private final CustomerRoleDAO customerRoleDAO;
    private final WalletDAO walletDAO;

    @Transactional(readOnly = true)
    public Customer login(String email, String password) {
        log.info("login service");
        Customer customer = Optional.ofNullable(customerDAO.findByEmailAndPassword(email, password))
                .orElseThrow(() -> new RuntimeException("customer doesn`t exist"));
        log.info(customer.toString());
        return customer;
    }

    @Override
    public List<Customer> allCustomers() {
        return customerDAO.getAll();
    }

    @Override
    public RegistrationResponse registration(RegistrationRequest request) {
        if (customerDAO.findByEmail(request.getEmail()) == null) {

            List<CustomerRole> customerRoleList = customerRoleDAO.getAll();
            CustomerRole customerRole = customerRoleList.stream().filter(role
                            -> role.getRole().toLowerCase().equals(CustomerRoleTypes.OWNER.name().toLowerCase()))
                    .findFirst().get();
            Customer customer = Customer.builder()
                    .email(request.getEmail())
                    .customerRole(customerRole)
                    .password(request.getPassword())
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .mobileNumber(request.getMobileNumber())
                    .build();
            customerDAO.create(customer);
            customer = customerDAO.findByEmail(request.getEmail());
            walletDAO.create(Wallet.builder().customer(customer).build());
            Wallet wallet = walletDAO.findByCustomerId(customer.getId());
            return RegistrationResponse.builder()
                    .walletId(wallet.getId())
                    .customerId(customer.getId())
                    .build();
        } else {
            return RegistrationResponse.builder()
                    .error(Error.builder().errorCode("422").errorMessage("Customer with email {" + request.getEmail() + "} already exist").build())
                    .build();
        }
    }

}
