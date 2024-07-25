package com.krtopi.backend.mission.achievement;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends MongoRepository<AchievementEntity, String> {
}
