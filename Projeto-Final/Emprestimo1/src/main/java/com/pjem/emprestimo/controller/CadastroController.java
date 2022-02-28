package com.pjem.emprestimo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pjem.emprestimo.model.Cadastro;
import com.pjem.emprestimo.service.CadastroService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/cadastro")

public class CadastroController {

    CadastroService cadastroService;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(CadastroController.class);

    @GetMapping( "/{email}")
    public ResponseEntity<Cadastro> findByIdCadastro(@PathVariable String email) {
        log.info("SOLICITANDO CADASTRO DENTRO DO CONTROLLER COM E-MAIL {}", email);
         return this.findByIdCadastro(email);
    }


    @DeleteMapping(value = "/{email}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteByCadastro(@PathVariable String email) {
        cadastroService.deletebyCadastro(email);
        log.info("Deletando cadastro com e-mail {}", email);
        return Mono.just(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cadastro> createCadastro(@RequestBody Cadastro cadastro) {
        log.info("Um novo cadastro foi criado");
        return cadastroService.save(cadastro);
    }

    @PutMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Cadastro> updateCadastro(@PathVariable String email,
                                                   @RequestBody Cadastro cadastro) {
        log.info("Atualizando cadastro com e-mail {}", email);
        return ResponseEntity.ok(cadastroService.updateCadastro(email, cadastro));
    }
    
}
