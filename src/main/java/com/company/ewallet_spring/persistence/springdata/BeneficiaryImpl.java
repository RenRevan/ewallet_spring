package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.BeneficiaryDAO;
import com.company.ewallet_spring.persistence.entities.Beneficiary;
import com.company.ewallet_spring.persistence.repositories.BeneficiaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BeneficiaryImpl implements BeneficiaryDAO {

    private final BeneficiaryRepository beneficiaryRepository;

    @Override
    public Beneficiary create(Beneficiary beneficiary) {
        return beneficiaryRepository.save(beneficiary);
    }

    @Override
    public Beneficiary update(Beneficiary beneficiary) {
        return beneficiaryRepository.save(beneficiary);
    }

    @Override
    public void delete(Beneficiary beneficiary) {
        beneficiaryRepository.delete(beneficiary);
    }

    @Override
    public Beneficiary get(int id) {
        return beneficiaryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Beneficiary> getAll() {
        return beneficiaryRepository.findAll();
    }
}
