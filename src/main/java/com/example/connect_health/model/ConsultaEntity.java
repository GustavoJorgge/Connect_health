package com.example.connect_health.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "consultas")
public class ConsultaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_usuario;
    private String tipo_consulta;
    private String especialidade;
    private String nome_medico;
    private String crm;
    private Date data;

    private String recorr;
    private String recorrencia;
    private String arquivo;

    public ConsultaEntity() {
    }

    public ConsultaEntity(Long id_usuario, String tipo_consulta, String especialidade, String nome_medico, String crm, Date data, String recorr, String recorrencia, String arquivo) {
        this.id_usuario = id_usuario;
        this.tipo_consulta = tipo_consulta;
        this.especialidade = especialidade;
        this.nome_medico = nome_medico;
        this.crm = crm;
        this.data = data;
        this.recorr = recorr;
        this.recorrencia = recorrencia;
        this.arquivo = arquivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome_medico() {
        return nome_medico;
    }

    public void setNome_medico(String nome_medico) {
        this.nome_medico = nome_medico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getRecorr() {
        return recorr;
    }

    public void setRecorr(String recorr) {
        this.recorr = recorr;
    }

    public String getRecorrencia() {
        return recorrencia;
    }

    public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }
}