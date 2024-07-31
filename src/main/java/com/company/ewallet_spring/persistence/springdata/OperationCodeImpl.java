package com.company.ewallet_spring.persistence.springdata;

import com.company.ewallet_spring.persistence.OperationCodeDAO;
import com.company.ewallet_spring.persistence.entities.OperationCode;
import com.company.ewallet_spring.persistence.repositories.OperationCodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class OperationCodeImpl implements OperationCodeDAO {

    private final OperationCodeRepository operationCodeRepository;

    @Override
    public OperationCode create(OperationCode operationCode) {
        return operationCodeRepository.save(operationCode);
    }

    @Override
    public OperationCode update(OperationCode operationCode) {
        return operationCodeRepository.save(operationCode);
    }

    @Override
    public void delete(OperationCode operationCode) {
        operationCodeRepository.delete(operationCode);
    }

    @Override
    public OperationCode get(int id) {
        return operationCodeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<OperationCode> getAll() {
        return operationCodeRepository.findAll();
    }
}
