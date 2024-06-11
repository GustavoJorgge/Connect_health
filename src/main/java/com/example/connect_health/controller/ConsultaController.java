package com.example.connect_health.controller;

import com.example.connect_health.model.ConsultaEntity;
import com.example.connect_health.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/armazenar")
    public ConsultaEntity armazenar(@RequestBody ConsultaEntity dados){
        System.out.println(dados);
        return consultaService.armazenaConsulta(dados);
    }
}
