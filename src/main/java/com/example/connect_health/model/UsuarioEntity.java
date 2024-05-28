package com.example.connect_health.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(name="planosaude")
    private String planoSaude;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datanasc;
    private String email;
    private String senha;

    public UsuarioEntity() {
        // Construtor sem argumentos necessário para o Hibernate
    }

    public UsuarioEntity(String nome, String planoSaude, LocalDate datanasc, String email, String senha) {
        this.nome = nome;
        this.planoSaude = planoSaude;
        this.datanasc = datanasc;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(String planoSaude) {
        this.planoSaude = planoSaude;
    }

    public LocalDate getDataNasc() {
        return datanasc;
    }

    public void setDataNasc(LocalDate datanasc) {
        this.datanasc = datanasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
