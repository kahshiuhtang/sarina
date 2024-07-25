package com.krtopi.backend.mission.validate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidateRepository extends MongoRepository<ValidateEntity, Long> {
}
