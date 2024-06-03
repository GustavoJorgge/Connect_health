package com.example.connect_health.controller;

import com.example.connect_health.enums.Comorbidade;
import com.example.connect_health.enums.TipoSanguineo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/enums")
public class CormobidadesController {

    @GetMapping("/comorbidades")
    public List<Comorbidade> getAllComorbidades(){
        return Arrays.asList(Comorbidade.values());
    }

    @GetMapping("/tiposanguineo")
    public List<TipoSanguineo> getAllTipoSanguineo() {
        return Arrays.asList(TipoSanguineo.values());
    }

}
