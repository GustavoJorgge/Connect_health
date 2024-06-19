package com.example.connect_health.model;

import com.example.connect_health.enums.Comorbidade;
import com.example.connect_health.enums.TipoSanguineo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "planosaude")
    private String planoSaude;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate datanasc;

    private String email;

    private String senha;

    @Column(name = "tipo_sanguineo")
    @Enumerated(EnumType.STRING)
    private TipoSanguineo tipoSanguineo;

    @Enumerated(EnumType.STRING)
    private Comorbidade comorbidades;

    private String sexo;

    public UsuarioEntity() {
        // Construtor padrão vazio
    }


    public UsuarioEntity(String nome, String planoSaude, LocalDate datanasc, String email, String senha, TipoSanguineo tipoSanguineo, String sexo) {
        this.nome = nome;
        this.planoSaude = planoSaude;
        this.datanasc = datanasc;
        this.email = email;
        this.senha = senha;
        this.tipoSanguineo = tipoSanguineo;
        this.sexo = sexo;
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

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Comorbidade getComorbidade() {
        return comorbidades;
    }

    public void setComorbidade(Comorbidade comorbidades) {
        this.comorbidades = comorbidades;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
