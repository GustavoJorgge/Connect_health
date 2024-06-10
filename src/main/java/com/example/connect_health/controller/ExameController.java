package com.example.connect_health.controller;

import com.example.connect_health.model.ExameEntity;
import com.example.connect_health.service.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exame")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @GetMapping("/busca")
    public List<ExameEntity> obterTodos(){
        return exameService.obterTodos();
    }
}
