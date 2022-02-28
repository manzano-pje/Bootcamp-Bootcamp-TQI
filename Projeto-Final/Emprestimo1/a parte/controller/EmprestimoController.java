package com.pjem.emprestimo.controller;

import com.pjem.emprestimo.model.Emprestimo;
import com.pjem.emprestimo.model.Cadastro;
import com.pjem.emprestimo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/emprestimo"})
public class EmprestimoController {
    @Autowired
    private final EmprestimoRepository repository;
    private Cadastro cadastro;

    EmprestimoController(EmprestimoRepository emprestimoRepository) {
        this.repository = emprestimoRepository;
    }
    @PostMapping
    public ResponseEntity<Emprestimo> save(@RequestBody Emprestimo emprestimo){
        repository.save(emprestimo);
        return new ResponseEntity<>(emprestimo, HttpStatus.OK);
    }

    @GetMapping(path = {"/todo"})
    public Iterable<Emprestimo> findAll(){
        return repository.findAll();

    }

 /*   @GetMapping(path = {"/simples/{id}"})
    public ResponseEntity<Emprestimo> simlpes(@PathVariable String id){
        return repository.findById(id)
                .map(emprestimo -> {
                    emprestimo.getCodigo();
                    emprestimo.getValorEmprestimo();
                    emprestimo.getParcelas();
                    return ResponseEntity.ok().body(emprestimo);
                }).orElse(ResponseEntity.notFound().build());

    }*/

 /*   @GetMapping(path = {"/detalhada/{id}"})
    public ResponseEntity<Emprestimo> detalhada(@PathVariable String id){
        return repository.findById(id)
                .map(emprestimo -> {
                    emprestimo.getCodigo();
                    emprestimo.getValorEmprestimo();
                    emprestimo.getParcelas();
                    emprestimo.getDataInicio();
                    emprestimo.getEmail();
                    cadastro.getRenda();
                    return ResponseEntity.ok().body(emprestimo);
                }).orElse(ResponseEntity.notFound().build());
    }*/
}
