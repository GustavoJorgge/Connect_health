package com.example.connect_health.model;

import java.util.Date;

public record DadosCadastroUsuario(String nome,
                                   String planoSaude,
                                   Date DataNac,
                                   String email,
                                   String senha) {

}
