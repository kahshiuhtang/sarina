package com.krtopi.backend.mission.user_status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserStatusService {

    @Autowired
    private UserStatusRepository userStatusRepository;

    public List<UserStatusEntity> findAll() {
        return userStatusRepository.findAll();
    }

    public Optional<UserStatusEntity> findById(String id) {
        return userStatusRepository.findById(id);
    }

    public Optional<UserStatusEntity> findByUserId(Long userId) {
        return userStatusRepository.findByUserId(userId);
    }

    public UserStatusEntity save(UserStatusEntity userStatusEntity) {
        return userStatusRepository.save(userStatusEntity);
    }

    public void deleteById(String id) {
        userStatusRepository.deleteById(id);
    }
    public Optional<UserStatusEntity> addAccomplishedMission(String id, String mission) {
        Optional<UserStatusEntity> userStatusOpt = userStatusRepository.findById(id);
        if (userStatusOpt.isPresent()) {
            UserStatusEntity userStatus = userStatusOpt.get();
            userStatus.getAccomplishedMissions().add(mission);
            userStatusRepository.save(userStatus);
        }
        return userStatusOpt;
    }
    public Optional<UserStatusEntity> addObtainedAchievement(String id, String achievementId) {
        Optional<UserStatusEntity> userStatusOpt = userStatusRepository.findById(id);
        if (userStatusOpt.isPresent()) {
            UserStatusEntity userStatus = userStatusOpt.get();
            userStatus.getObtainedAchievements().add(achievementId);
            userStatusRepository.save(userStatus);
        }
        return userStatusOpt;
    }
    public Optional<UserStatusEntity> addObtainedSticker(String id, String stickerId) {
        Optional<UserStatusEntity> userStatusOpt = userStatusRepository.findById(id);
        if (userStatusOpt.isPresent()) {
            UserStatusEntity userStatus = userStatusOpt.get();
            userStatus.getObtainedStickers().add(stickerId);
            userStatusRepository.save(userStatus);
        }
        return userStatusOpt;
    }
    public Optional<UserStatusEntity> addMissionPost(String id, String missionPostId) {
        Optional<UserStatusEntity> userStatusOpt = userStatusRepository.findById(id);
        if (userStatusOpt.isPresent()) {
            UserStatusEntity userStatus = userStatusOpt.get();
            userStatus.getMissionPosts().add(missionPostId);
            userStatusRepository.save(userStatus);
        }
        return userStatusOpt;
    }
}