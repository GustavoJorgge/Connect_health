package com.example.connect_health.controller;

import com.example.connect_health.dto.LoginRequestDTO;
import com.example.connect_health.dto.ResponseDTO;
import com.example.connect_health.enums.Comorbidade;
import com.example.connect_health.infra.security.TokenService;
import com.example.connect_health.model.UsuarioEntity;
import com.example.connect_health.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ResponseDTO> cadastrar(@RequestBody UsuarioEntity dados){
        //verificando se o e-mail ja é cadastrado
        Optional<UsuarioEntity> usuarioEntity = usuarioService.findByEmail(dados.getEmail());
        if(usuarioEntity.isEmpty()){
            //Objeto de usuario com os dados obtidos no json
            UsuarioEntity newUsuario = new UsuarioEntity(dados.getNome(), dados.getPlanoSaude(), dados.getDataNasc(), dados.getEmail(), dados.getSenha(), dados.getTipoSanguineo(), dados.getComorbidade(), dados.getSexo());
            usuarioService.cadastrarUsuario(newUsuario);
            String token = this.tokenService.generateToken(newUsuario);
            return ResponseEntity.ok(new ResponseDTO(token));
        }
        return  ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        UsuarioEntity usuarioEntity = usuarioService.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User Not Found"));
        if (body.senha().equals(usuarioEntity.getSenha())) {
            String token = this.tokenService.generateToken(usuarioEntity);
            return ResponseEntity.ok(new ResponseDTO(token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/atualizar/{id}")
    public UsuarioEntity atualizar(@PathVariable Long id, @RequestBody UsuarioEntity user){
        return usuarioService.atualizar(id,user);
    }

    @GetMapping("/buscarUsuarios")
    public List<UsuarioEntity> obterTodos() {
        return usuarioService.obterTodos();
    }
}
