package com.krtopi.backend.mission.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/milestone_posts")
public class MissionPostController {

    @Autowired
    private MissionPostService missionPostService;

    @GetMapping
    public List<MissionPostEntity> getAllMissionPosts() {
        return missionPostService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionPostEntity> getMissionPostById(@PathVariable String id) {
        return missionPostService.findById(id)
                .map(missionPost -> new ResponseEntity<>(missionPost, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public MissionPostEntity createMissionPost(@RequestBody MissionPostEntity missionPost) {
        return missionPostService.save(missionPost);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissionPostEntity> updateMissionPost(@PathVariable String id, @RequestBody MissionPostEntity missionPost) {
        return missionPostService.findById(id)
                .map(existingMissionPost -> {
                    existingMissionPost.setOwnerUserId(missionPost.getOwnerUserId());
                    existingMissionPost.setMissionId(missionPost.getMissionId());
                    existingMissionPost.setTitle(missionPost.getTitle());
                    existingMissionPost.setDescription(missionPost.getDescription());
                    existingMissionPost.setImages(missionPost.getImages());
                    existingMissionPost.setTags(missionPost.getTags());
                    existingMissionPost.setLocation(missionPost.getLocation());
                    existingMissionPost.setUpdatedAt(missionPost.getUpdatedAt());
                    existingMissionPost.setVersion(missionPost.getVersion());
                    return new ResponseEntity<>(missionPostService.save(existingMissionPost), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMissionPost(@PathVariable String id) {
        if (missionPostService.findById(id).isPresent()) {
            missionPostService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
