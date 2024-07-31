package com.company.ewallet_spring.persistence.repositories;

import com.company.ewallet_spring.persistence.entities.CustomerRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRoleRepository extends JpaRepository<CustomerRole, Integer> {
}
