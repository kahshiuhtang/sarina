package com.krtopi.backend.mission.achievement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/achievements")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @GetMapping
    public List<AchievementEntity> getAllAchievements() {
        return achievementService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AchievementEntity> getAchievementById(@PathVariable String id) {
        return achievementService.findById(id)
                .map(achievement -> new ResponseEntity<>(achievement, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public AchievementEntity createAchievement(@RequestBody AchievementEntity achievement) {
        return achievementService.save(achievement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AchievementEntity> updateAchievement(@PathVariable String id, @RequestBody AchievementEntity achievement) {
        return achievementService.findById(id)
                .map(existingAchievement -> {
                    existingAchievement.setTitle(achievement.getTitle());
                    existingAchievement.setDescription(achievement.getDescription());
                    return new ResponseEntity<>(achievementService.save(existingAchievement), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable String id) {
        if (achievementService.findById(id).isPresent()) {
            achievementService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}