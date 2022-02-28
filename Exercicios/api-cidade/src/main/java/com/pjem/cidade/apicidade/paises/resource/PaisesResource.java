package com.pjem.cidade.apicidade.paises.resource;

import com.pjem.cidade.apicidade.paises.entities.Paises;
import com.pjem.cidade.apicidade.paises.repository.PaisesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

public class PaisesResource {
    private final PaisesRepository repository;

    public PaisesResource(final PaisesRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/paises")
    public List<Paises> cidades() {
        return repository.findAll();
    }

}
