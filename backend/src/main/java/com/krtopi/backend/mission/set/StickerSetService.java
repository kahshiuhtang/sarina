package com.krtopi.backend.mission.set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StickerSetService {

    @Autowired
    private StickerSetRepository setRepository;

    public List<StickerSetEntity> findAll() {
        return setRepository.findAll();
    }

    public Optional<StickerSetEntity> findById(String id) {
        return setRepository.findById(id);
    }

    public StickerSetEntity save(StickerSetEntity setEntity) {
        return setRepository.save(setEntity);
    }

    public void deleteById(String id) {
        setRepository.deleteById(id);
    }
}