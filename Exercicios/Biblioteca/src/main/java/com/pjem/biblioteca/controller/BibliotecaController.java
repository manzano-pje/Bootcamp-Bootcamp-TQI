package com.pjem.biblioteca.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.pjem.biblioteca.service.BibliotecaService;
import com.pjem.biblioteca.document.Biblioteca;
import com.pjem.biblioteca.repository.BibliotecaRepository;
import static com.pjem.biblioteca.constants.BibliotecaConstants.BIBLIOTECA_ENDPOINT_LOCAL;

@RestController
//@Slf4j
public class BibliotecaController {
    BibliotecaService bibliotecaService;
    BibliotecaRepository bibliotecaRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(BibliotecaController.class);

    public BibliotecaController(BibliotecaService bibliotecaService, BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaService = bibliotecaService;
        this.bibliotecaRepository = bibliotecaRepository;
    }

    @GetMapping(BIBLIOTECA_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Biblioteca> getAllItems() {
        log.info("requisitando a lista de todos os livros");
        return bibliotecaService.findAll();
    }

    @GetMapping(BIBLIOTECA_ENDPOINT_LOCAL + "/{isbn}")
    public Mono<ResponseEntity<Biblioteca>> findByIdBiblioteca(@PathVariable String isbn) {

        log.info("Solicitando livro com ISBN {}", isbn);
        return bibliotecaService.findByIdBiblioteca(isbn)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(BIBLIOTECA_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Biblioteca> createHero(@RequestBody Biblioteca biblioteca) {
        log.info("Um novo livro foi adicionado !");
        return bibliotecaService.save(biblioteca);
    }

    @DeleteMapping(BIBLIOTECA_ENDPOINT_LOCAL + "/{isbn}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDBiblioteca(@PathVariable String isbn) {
        bibliotecaService.deletebyIDBiblioteca(isbn);
        log.info("Apagando livro com ISBN {}", isbn);
        return Mono.just(HttpStatus.NOT_FOUND);
    }
}
