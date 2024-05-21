package com.example.connect_health.service;

import com.example.connect_health.model.UsuarioEntity;
import com.example.connect_health.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository userRepository;

    public UsuarioEntity cadastrarUsuario(UsuarioEntity user){
        System.out.println(user);
        return userRepository.save(user);
    }
}
