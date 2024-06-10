package com.example.connect_health.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "exames")
public class ExameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long id_usuario;
    private String tipo_exame;
    private String nome_exame;
    private Date data;
    private String recorr;
    private String recorrencia;
    private String arquivo;
    private String nome_medico;
    private String crm;

    public ExameEntity(long id_usuario, String tipo_exame, String nome_exame, Date data, String recorr, String recorrencia, String arquivo, String nome_medico, String crm) {
        this.id_usuario = id_usuario;
        this.tipo_exame = tipo_exame;
        this.nome_exame = nome_exame;
        this.data = data;
        this.recorr = recorr;
        this.recorrencia = recorrencia;
        this.arquivo = arquivo;
        this.nome_medico = nome_medico;
        this.crm = crm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo_exame() {
        return tipo_exame;
    }

    public void setTipo_exame(String tipo_exame) {
        this.tipo_exame = tipo_exame;
    }

    public String getNome_exame() {
        return nome_exame;
    }

    public void setNome_exame(String nome_exame) {
        this.nome_exame = nome_exame;
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
}
