package com.krtopi.backend.mission.sticker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StickerRepository extends MongoRepository<StickerEntity, Long> {
}