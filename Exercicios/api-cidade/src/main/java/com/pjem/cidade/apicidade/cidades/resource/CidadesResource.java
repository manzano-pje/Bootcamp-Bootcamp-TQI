package com.pjem.cidade.apicidade.cidades.resource;

import com.pjem.cidade.apicidade.cidades.entities.Cidades;
import com.pjem.cidade.apicidade.cidades.repository.CidadesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cidade")
public class CidadesResource {
    private final CidadesRepository repository;

    public CidadesResource(final CidadesRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Cidades> cidades(final Pageable page) {
        return repository.findAll(page);
    }
}
