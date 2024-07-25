package com.krtopi.backend.mission.sticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StickerService {

    @Autowired
    private StickerRepository stickerRepository;

    public List<StickerEntity> findAll() {
        return stickerRepository.findAll();
    }

    public Optional<StickerEntity> findById(Long id) {
        return stickerRepository.findById(id);
    }

    public StickerEntity save(StickerEntity stickerEntity) {
        return stickerRepository.save(stickerEntity);
    }

    public void deleteById(Long id) {
        stickerRepository.deleteById(id);
    }
}
