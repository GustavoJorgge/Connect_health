package com.example.connect_health.controller;

import com.example.connect_health.model.UsuarioEntity;
import com.example.connect_health.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UserController {

     @Autowired
     private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public UsuarioEntity cadastrar(@RequestBody UsuarioEntity dados){
        return usuarioService.cadastrarUsuario(dados);
    }

    
}
