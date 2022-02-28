package com.pjem.biblioteca.service;

import com.pjem.biblioteca.document.Biblioteca;
import com.pjem.biblioteca.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BibliotecaService {
    private final BibliotecaRepository bibliotecaRepository;

    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public Flux<Biblioteca> findAll(){
        return Flux.fromIterable(this.bibliotecaRepository.findAll());
    }

    public  Mono<Biblioteca> findByIdBiblioteca(String isbn){
        return  Mono.justOrEmpty(this.bibliotecaRepository.findById(isbn));
    }

    public Mono<Biblioteca> save(Biblioteca biblioteca){
        return  Mono.justOrEmpty(this.bibliotecaRepository.save(biblioteca));
    }

    public Mono<Boolean> deletebyIDBiblioteca(String isbn) {
        bibliotecaRepository.deleteById(isbn);
        return Mono.just(true);
    }
}
