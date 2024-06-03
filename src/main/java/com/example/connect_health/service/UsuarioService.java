package com.example.connect_health.service;

import com.example.connect_health.model.UsuarioEntity;
import com.example.connect_health.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity cadastrarUsuario(UsuarioEntity user){
        System.out.println(user);
        return usuarioRepository.save(user);
    }

    public Optional<UsuarioEntity> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public UsuarioEntity atualizar(Long id, UsuarioEntity usuario) {
        UsuarioEntity existingUser = usuarioRepository.findById(usuario.getId()).orElse(null);

        if(existingUser != null){
            existingUser.setNome(usuario.getNome());
            existingUser.setEmail(usuario.getEmail());
            existingUser.setPlanoSaude(usuario.getPlanoSaude());
            existingUser.setComorbidade(usuario.getComorbidade());
            existingUser.setTipoSanguineo(usuario.getTipoSanguineo());
            return usuarioRepository.save(existingUser);
        }else{
            return null;
        }
    }

    public UsuarioEntity obterPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public List<UsuarioEntity> obterTodos() {
        return usuarioRepository.findAll();
    }
}
