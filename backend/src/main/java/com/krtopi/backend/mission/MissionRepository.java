package com.krtopi.backend.mission;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends MongoRepository<MissionEntity, String> {
}