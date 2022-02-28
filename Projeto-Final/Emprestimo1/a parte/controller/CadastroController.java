package com.pjem.emprestimo.controller;

import com.pjem.emprestimo.constants.CadastroConstant;
import com.pjem.emprestimo.model.Cadastro;
import com.pjem.emprestimo.repository.CadastroRepository;
import com.pjem.emprestimo.service.CadastroService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping({"/cadastro"})
public class CadastroController {

    private CadastroRepository cadastroRepository;
    private CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService,
                              CadastroRepository cadastroRepository) {
        this.cadastroService = cadastroService;
        this.cadastroRepository = cadastroRepository;
    }

    @GetMapping("/{email}")
    public Mono<ResponseEntity<Cadastro>> findByIdHero(@PathVariable String email) {
           return cadastroService.findByICadastro(email)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deletebyIDCadastro(@PathVariable String email) {
        cadastroService.deletebyICadastro(email);
        return Mono.just(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Cadastro> createCadastro(@RequestBody Cadastro cadastro) {
        return cadastroService.save(cadastro);
    }

   @PutMapping("/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String email, @RequestBody Cadastro cadastro){
            //throws EntityNotFound {
        // log.info("Updating book id = {} into the db", email)
        cadastroService.save(cadastro );
    }

 /*
    @PutMapping(value="/{email}")
    public ResponseEntity<Cadastro> update(@PathVariable String email,
                                             @RequestBody Cadastro newCadastro){
         return cadastroService.findByICadastro(email)
              .map(cadastro -> {
                  cadastro.setNome(newCadastro.getNome());
                  cadastro.setEmail(newCadastro.getEmail());
                  cadastro.setRg(newCadastro.getRg());
                  cadastro.setEndereco(newCadastro.getEndereco());
                  cadastro.setComplemento(newCadastro.getComplemento());
                  cadastro.setCep(newCadastro.getCep());
                  cadastro.setCidade(newCadastro.getCidade());
                  cadastro.setUf(newCadastro.getUf());
                  cadastro.setRenda(newCadastro.getRenda());
                  cadastro.setSenha(newCadastro.getSenha());

                  Cadastro cadastroUpdated = cadastroRepository.save(cadastro);
                  return ResponseEntity.ok().body(cadastroUpdated);
              });
      }*/

}
