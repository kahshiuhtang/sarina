package com.krtopi.backend.mission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missions")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @GetMapping
    public List<MissionEntity> getAllMissions() {
        return missionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionEntity> getMissionById(@PathVariable String id) {
        return missionService.findById(id)
                .map(missionEntity -> new ResponseEntity<>(missionEntity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public MissionEntity createMission(@RequestBody MissionEntity missionEntity) {
        return missionService.save(missionEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissionEntity> updateMission(@PathVariable String id, @RequestBody MissionEntity missionEntity) {
        return missionService.findById(id)
                .map(existingMission -> {
                    existingMission.setTitle(missionEntity.getTitle());
                    existingMission.setDescription(missionEntity.getDescription());
                    existingMission.setIssuedDate(missionEntity.getIssuedDate());
                    existingMission.setExpirationDate(missionEntity.getExpirationDate());
                    return new ResponseEntity<>(missionService.save(existingMission), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMission(@PathVariable String id) {
        if (missionService.findById(id).isPresent()) {
            missionService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
