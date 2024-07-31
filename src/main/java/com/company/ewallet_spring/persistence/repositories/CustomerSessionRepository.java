package com.company.ewallet_spring.persistence.repositories;

import com.company.ewallet_spring.persistence.entities.CustomerSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerSessionRepository extends JpaRepository<CustomerSession, Integer> {
}
