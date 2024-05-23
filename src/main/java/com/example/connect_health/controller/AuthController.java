package com.example.connect_health.controller;

import com.example.connect_health.dto.LoginRequestDTO;
import com.example.connect_health.dto.ResponseDTO;
import com.example.connect_health.infra.security.TokenService;
import com.example.connect_health.model.UsuarioEntity;
import com.example.connect_health.repository.UsuarioRepository;
import com.example.connect_health.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;
    private TokenService tokenService;
     @Autowired
     private UsuarioService usuarioService;

//    @PostMapping("/cadastrar")
//    @Transactional
//    public UsuarioEntity cadastrar(@RequestBody UsuarioEntity dados){
//        return usuarioService.cadastrarUsuario(dados);
//    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ResponseDTO> cadastrar(@RequestBody UsuarioEntity dados){
        Optional<UsuarioEntity> usuarioEntity = this.usuarioRepository.findByEmail(dados.getEmail());

        if(usuarioEntity.isEmpty()){
            UsuarioEntity newUsuario = new UsuarioEntity();
            newUsuario.setEmail(dados.getEmail());
            newUsuario.setNome(dados.getNome());
            newUsuario.setDataNasc(dados.getDataNasc());
            newUsuario.setSenha(dados.getSenha());
            newUsuario.setPlanoSaude(dados.getPlanoSaude());
            usuarioService.cadastrarUsuario(newUsuario);

            String token = this.tokenService.generateToken(newUsuario);
            return ResponseEntity.ok(new ResponseDTO(token));
        }
        return  ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        UsuarioEntity usuarioEntity = this.usuarioRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User Not Found"));
        if(passwordEncoder.matches(usuarioEntity.getSenha(), body.senha())){
            String token = this.tokenService.generateToken(usuarioEntity);
            return ResponseEntity.ok(new ResponseDTO(token));
        }

        return ResponseEntity.badRequest().build();
    }
    
}
