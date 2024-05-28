package com.example.connect_health.controller;

import com.example.connect_health.dto.LoginRequestDTO;
import com.example.connect_health.dto.ResponseDTO;
import com.example.connect_health.infra.security.TokenService;
import com.example.connect_health.model.UsuarioEntity;
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
public class AuthController {

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
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
        System.out.println("CHEGOU AQUI");
        Optional<UsuarioEntity> usuarioEntity = usuarioService.findByEmail(dados.getEmail());
        if(usuarioEntity.isEmpty()){
            UsuarioEntity newUsuario = new UsuarioEntity(dados.getNome(), dados.getPlanoSaude(), dados.getDataNasc(), dados.getEmail(), dados.getSenha());
            usuarioService.cadastrarUsuario(newUsuario);

            String token = this.tokenService.generateToken(newUsuario);
            return ResponseEntity.ok(new ResponseDTO(token));
        }
        return  ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        UsuarioEntity usuarioEntity = usuarioService.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User Not Found"));
        System.out.println(usuarioEntity.getEmail());
        System.out.println("Senha body:" + body.senha());
        System.out.println("Senha Usuario:" + usuarioEntity.getSenha());

        if (body.senha().equals(usuarioEntity.getSenha())) {
            String token = this.tokenService.generateToken(usuarioEntity);
            return ResponseEntity.ok(new ResponseDTO(token));
        }

        return ResponseEntity.badRequest().build();
    }
    
}
