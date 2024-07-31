package com.company.ewallet_spring.persistence.repositories;

import com.company.ewallet_spring.persistence.entities.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {
}
