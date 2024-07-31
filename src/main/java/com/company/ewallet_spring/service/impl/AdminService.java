package com.company.ewallet_spring.service.impl;

import com.company.ewallet_spring.persistence.CustomerDAO;
import com.company.ewallet_spring.persistence.CustomerRoleDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class AdminService {
    private final CustomerDAO customerDAO;
    private final CustomerRoleDAO customerRoleDAO;


}
