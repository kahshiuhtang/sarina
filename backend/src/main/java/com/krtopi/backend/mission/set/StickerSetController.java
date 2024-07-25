package com.krtopi.backend.mission.set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/sets")
public class StickerSetController {

    @Autowired
    private StickerSetService setService;

    @GetMapping
    public List<StickerSetEntity> getAllSets() {
        return setService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StickerSetEntity> getSetById(@PathVariable String id) {
        return setService.findById(id)
                .map(setEntity -> new ResponseEntity<>(setEntity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public StickerSetEntity createSet(@RequestBody StickerSetEntity setEntity) {
        return setService.save(setEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StickerSetEntity> updateSet(@PathVariable String id, @RequestBody StickerSetEntity setEntity) {
        return setService.findById(id)
                .map(existingSet -> {
                    existingSet.setSetName(setEntity.getSetName());
                    existingSet.setImageURL(setEntity.getImageURL());
                    existingSet.setAssociatedStickerId(setEntity.getAssociatedStickerId());
                    return new ResponseEntity<>(setService.save(existingSet), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSet(@PathVariable String id) {
        if (setService.findById(id).isPresent()) {
            setService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
