package com.example.connect_health.controller;

import com.example.connect_health.model.ExameEntity;
import com.example.connect_health.service.ExameService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/armazenar")
    public ExameEntity armazenar(@RequestBody ExameEntity dados){
        System.out.println(dados);
        return exameService.armazenaExame(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String removeExame (@PathVariable long id){
        return exameService.removeExame(id);
    }
}
