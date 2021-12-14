package com.test.artemistest.service;

import com.test.artemistest.models.ArtemisLogEntity;
import com.test.artemistest.repository.ArtemisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtemisServiceImpl implements ArtemisService {

    ArtemisRepository repository;

    @Autowired
    public ArtemisServiceImpl(ArtemisRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addLog(String message, String destination) {
        repository.save(new ArtemisLogEntity(message, destination));
    }
}
