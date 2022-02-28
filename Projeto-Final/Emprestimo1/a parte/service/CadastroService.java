package com.pjem.emprestimo.service;

import com.pjem.emprestimo.model.Cadastro;
import com.pjem.emprestimo.repository.CadastroRepository;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CadastroService {
    private final CadastroRepository cadastroRepository;

    public CadastroService(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    public Mono<Cadastro> findByICadastro(String id){
        return  Mono.justOrEmpty(this.cadastroRepository.findById(id));
    }

    public Mono<Cadastro> save(Cadastro heroes){
        return  Mono.justOrEmpty(this.cadastroRepository.save(heroes));
    }

    public Mono<Boolean> deletebyICadastro(String id) {
        cadastroRepository.deleteById(id);
        return Mono.just(true);
    }

}