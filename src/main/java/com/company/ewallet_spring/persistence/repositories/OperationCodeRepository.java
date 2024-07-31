package com.company.ewallet_spring.persistence.repositories;

import com.company.ewallet_spring.persistence.entities.OperationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationCodeRepository extends JpaRepository<OperationCode, Integer> {
}
