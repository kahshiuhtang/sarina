package com.krtopi.backend.mission.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidateService {

    @Autowired
    private ValidateRepository validateRepository;

    public List<ValidateEntity> findAll() {
        return validateRepository.findAll();
    }

    public Optional<ValidateEntity> findById(Long id) {
        return validateRepository.findById(id);
    }

    public ValidateEntity save(ValidateEntity validateEntity) {
        return validateRepository.save(validateEntity);
    }

    public void deleteById(Long id) {
        validateRepository.deleteById(id);
    }
}
