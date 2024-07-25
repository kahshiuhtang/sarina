package com.krtopi.backend.mission.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionPostService {

    @Autowired
    private MissionPostRepository missionPostRepository;

    public List<MissionPostEntity> findAll() {
        return missionPostRepository.findAll();
    }

    public Optional<MissionPostEntity> findById(String id) {
        return missionPostRepository.findById(id);
    }

    public MissionPostEntity save(MissionPostEntity missionPost) {
        return missionPostRepository.save(missionPost);
    }

    public void deleteById(String id) {
        missionPostRepository.deleteById(id);
    }
}
