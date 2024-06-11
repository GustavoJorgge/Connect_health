package com.example.connect_health.service;

import com.example.connect_health.model.ConsultaEntity;
import com.example.connect_health.model.ExameEntity;
import com.example.connect_health.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public List<ConsultaEntity> obterTodas(){
        return consultaRepository.findAll();
    }

    public ConsultaEntity armazenaConsulta(ConsultaEntity dados){
        return consultaRepository.save(dados);
    }

    public String removeConsulta(Long id){
        consultaRepository.deleteById(id);
        return "Consulta deletada com sucesso!";
    }

    public ConsultaEntity atualizar (Long id, ConsultaEntity consulta){
        ConsultaEntity existingConsulta = consultaRepository.findById(consulta.getId()).orElse(null);

        if(existingConsulta != null){
            existingConsulta.setTipo_consulta(consulta.getTipo_consulta());
            existingConsulta.setEspecialidade(consulta.getEspecialidade());
            existingConsulta.setNome_medico(consulta.getNome_medico());
            existingConsulta.setCrm(consulta.getCrm());
            existingConsulta.setData(consulta.getData());
            existingConsulta.setRecorr(consulta.getRecorr());
            existingConsulta.setRecorrencia(consulta.getRecorrencia());
            existingConsulta.setArquivo(consulta.getArquivo());
            return consultaRepository.save(existingConsulta);
        }else{
            return null;
        }

    }

}
