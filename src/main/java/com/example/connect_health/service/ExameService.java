package com.example.connect_health.service;

import com.example.connect_health.model.ExameEntity;
import com.example.connect_health.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public List<ExameEntity> obterTodos(){
        return exameRepository.findAll();
    }
}
