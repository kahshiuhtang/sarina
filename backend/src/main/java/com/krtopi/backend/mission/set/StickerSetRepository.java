package com.krtopi.backend.mission.set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerSetRepository extends MongoRepository<StickerSetEntity, String> {
}