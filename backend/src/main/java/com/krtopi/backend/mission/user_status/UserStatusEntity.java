package com.krtopi.backend.mission.user_status;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

@Document(collection = "user-statuses")
public class UserStatusEntity {
    @Id
    private String id;
    private Long userId;
    private List<String> accomplishedMissions;
    private List<String> obtainedAchievements;
    private Set<String> obtainedStickers;
    private Set<String> missionPosts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getAccomplishedMissions() {
        return accomplishedMissions;
    }

    public void setAccomplishedMissions(List<String> accomplishedMissions) {
        this.accomplishedMissions = accomplishedMissions;
    }

    public List<String> getObtainedAchievements() {
        return obtainedAchievements;
    }

    public void setObtainedAchievements(List<String> obtainedAchievements) {
        this.obtainedAchievements = obtainedAchievements;
    }

    public Set<String> getObtainedStickers() {
        return obtainedStickers;
    }

    public void setObtainedStickers(Set<String> obtainedStickers) {
        this.obtainedStickers = obtainedStickers;
    }

    public Set<String> getMissionPosts() {
        return missionPosts;
    }

    public void setMissionPosts(Set<String> posts) {
        this.missionPosts = posts;
    }
}
