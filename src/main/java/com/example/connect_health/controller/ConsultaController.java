package com.example.connect_health.controller;

import com.example.connect_health.model.ConsultaEntity;
import com.example.connect_health.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/busca")
    public List<ConsultaEntity> obterTodas(){
        return consultaService.obterTodas();
    }
}
