package com.krtopi.backend.mission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;

    public List<MissionEntity> findAll() {
        return missionRepository.findAll();
    }

    public Optional<MissionEntity> findById(String id) {
        return missionRepository.findById(id);
    }

    public MissionEntity save(MissionEntity missionEntity) {
        return missionRepository.save(missionEntity);
    }

    public void deleteById(String id) {
        missionRepository.deleteById(id);
    }
}
