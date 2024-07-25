package com.krtopi.backend.mission.user_status;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserStatusRepository extends MongoRepository<UserStatusEntity, String> {
    Optional<UserStatusEntity> findByUserId(Long userId);
}
