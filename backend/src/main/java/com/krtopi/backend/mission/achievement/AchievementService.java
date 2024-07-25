package com.krtopi.backend.mission.achievement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository achievementRepository;

    public List<AchievementEntity> findAll() {
        return achievementRepository.findAll();
    }

    public Optional<AchievementEntity> findById(String id) {
        return achievementRepository.findById(id);
    }

    public AchievementEntity save(AchievementEntity achievement) {
        return achievementRepository.save(achievement);
    }

    public void deleteById(String id) {
        achievementRepository.deleteById(id);
    }
}
