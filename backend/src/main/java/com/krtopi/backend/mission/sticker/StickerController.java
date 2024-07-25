package com.krtopi.backend.mission.sticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stickers")
public class StickerController {

    @Autowired
    private StickerService stickerService;

    @GetMapping
    public List<StickerEntity> getAllStickers() {
        return stickerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StickerEntity> getStickerById(@PathVariable Long id) {
        return stickerService.findById(id)
                .map(stickerEntity -> new ResponseEntity<>(stickerEntity, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public StickerEntity createSticker(@RequestBody StickerEntity stickerEntity) {
        return stickerService.save(stickerEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StickerEntity> updateSticker(@PathVariable Long id, @RequestBody StickerEntity stickerEntity) {
        return stickerService.findById(id)
                .map(existingSticker -> {
                    existingSticker.setTitle(stickerEntity.getTitle());
                    existingSticker.setRarity(stickerEntity.getRarity());
                    existingSticker.setDescription(stickerEntity.getDescription());
                    existingSticker.setImageUrl(stickerEntity.getImageUrl());
                    existingSticker.setParentSetName(stickerEntity.getParentSetName());
                    existingSticker.setCreatedDate(stickerEntity.getCreatedDate());
                    return new ResponseEntity<>(stickerService.save(existingSticker), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSticker(@PathVariable Long id) {
        if (stickerService.findById(id).isPresent()) {
            stickerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
