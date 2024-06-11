package com.example.connect_health.service;

import com.example.connect_health.model.ConsultaEntity;
import com.example.connect_health.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<ConsultaEntity> obterTodas(){
        return consultaRepository.findAll();
    }
}
