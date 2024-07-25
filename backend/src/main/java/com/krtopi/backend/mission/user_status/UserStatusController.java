package com.krtopi.backend.mission.user_status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/user-status")
public class UserStatusController {

    @Autowired
    private UserStatusService userStatusService;

    @GetMapping
    public List<UserStatusEntity> getAllUserStatuses() {
        return userStatusService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserStatusEntity> getUserStatusById(@PathVariable String id) {
        return userStatusService.findById(id)
                .map(userStatusEntity -> new ResponseEntity<>(userStatusEntity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserStatusEntity> getUserStatusByUserId(@PathVariable Long userId) {
        return userStatusService.findByUserId(userId)
                .map(userStatusEntity -> new ResponseEntity<>(userStatusEntity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public UserStatusEntity createUserStatus(@RequestBody UserStatusEntity userStatusEntity) {
        return userStatusService.save(userStatusEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserStatusEntity> updateUserStatus(@PathVariable String id, @RequestBody UserStatusEntity userStatusEntity) {
        return userStatusService.findById(id)
                .map(existingUserStatus -> {
                    existingUserStatus.setUserId(userStatusEntity.getUserId());
                    existingUserStatus.setAccomplishedMissions(userStatusEntity.getAccomplishedMissions());
                    existingUserStatus.setObtainedAchievements(userStatusEntity.getObtainedAchievements());
                    existingUserStatus.setObtainedStickers(userStatusEntity.getObtainedStickers());
                    existingUserStatus.setMissionPosts(userStatusEntity.getMissionPosts());
                    return new ResponseEntity<>(userStatusService.save(existingUserStatus), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserStatus(@PathVariable String id) {
        if (userStatusService.findById(id).isPresent()) {
            userStatusService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/{id}/accomplished-missions")
    public ResponseEntity<UserStatusEntity> addAccomplishedMission(@PathVariable String id, @RequestBody String missionId) {
        return userStatusService.addAccomplishedMission(id, missionId)
                .map(userStatus -> new ResponseEntity<>(userStatus, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/{id}/obtained-sticker")
    public ResponseEntity<UserStatusEntity> addObtainedSticker(@PathVariable String id, @RequestBody String stickerId) {
        return userStatusService.addObtainedSticker(id, stickerId)
                .map(userStatus -> new ResponseEntity<>(userStatus, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/{id}/obtained-achievement")
    public ResponseEntity<UserStatusEntity> addObtainedAchievement(@PathVariable String id, @RequestBody String achievementId) {
        return userStatusService.addObtainedAchievement(id, achievementId)
                .map(userStatus -> new ResponseEntity<>(userStatus, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/{id}/mission-post")
    public ResponseEntity<UserStatusEntity> addMissionPost(@PathVariable String id, @RequestBody String postId) {
        return userStatusService.addMissionPost(id, postId)
                .map(userStatus -> new ResponseEntity<>(userStatus, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
