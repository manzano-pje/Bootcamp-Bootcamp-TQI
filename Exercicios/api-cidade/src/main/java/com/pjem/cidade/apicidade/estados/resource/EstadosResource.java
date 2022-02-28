package com.pjem.cidade.apicidade.estados.resource;

import com.pjem.cidade.apicidade.estados.entities.Estados;
import com.pjem.cidade.apicidade.estados.repository.EstadosRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Estados")
public class EstadosResource {

    private final EstadosRepository repository;

    public EstadosResource(final EstadosRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Estados> states() {
        return repository.findAll();
    }
}
