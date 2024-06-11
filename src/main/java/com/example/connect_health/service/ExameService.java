package com.example.connect_health.service;

import com.example.connect_health.model.ExameEntity;
import com.example.connect_health.model.UsuarioEntity;
import com.example.connect_health.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    public List<ExameEntity> obterTodos(){
        return exameRepository.findAll();
    }

    public ExameEntity armazenaExame(ExameEntity dados){
        return exameRepository.save(dados);
    }

    public String removeExame(long id){
        exameRepository.deleteById(id);
        return "Exame removido com sucesso!";
    }

    public ExameEntity atualizar (Long id, ExameEntity exame){
        ExameEntity existingExame = exameRepository.findById(exame.getId()).orElse(null);

        if(existingExame != null){
            existingExame.setTipo_exame(exame.getTipo_exame());
            existingExame.setNome_exame(exame.getNome_exame());
            existingExame.setData(exame.getData());
            existingExame.setRecorr(exame.getRecorr());
            existingExame.setRecorrencia(exame.getRecorrencia());
            existingExame.setArquivo(exame.getArquivo());
            existingExame.setNome_medico(exame.getNome_medico());
            return exameRepository.save(existingExame);
        }else{
            return null;
        }

    }

//    public UsuarioEntity atualizar(Long id, UsuarioEntity usuario) {
//        UsuarioEntity existingUser = usuarioRepository.findById(usuario.getId()).orElse(null);
//
//        if(existingUser != null){
//            existingUser.setNome(usuario.getNome());
//            existingUser.setEmail(usuario.getEmail());
//            existingUser.setPlanoSaude(usuario.getPlanoSaude());
//            existingUser.setComorbidade(usuario.getComorbidade());
//            existingUser.setTipoSanguineo(usuario.getTipoSanguineo());
//            return usuarioRepository.save(existingUser);
//        }else{
//            return null;
//        }
//    }
}
