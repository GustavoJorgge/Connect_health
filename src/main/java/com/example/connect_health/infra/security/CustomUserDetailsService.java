package com.example.connect_health.infra.security;

import com.example.connect_health.model.UsuarioEntity;
import com.example.connect_health.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UsuarioEntity usuarioEntity = this.repository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return new org.springframework.security.core.userdetails.User(usuarioEntity.getEmail(),usuarioEntity.getSenha(),new ArrayList<>());
    }
}
