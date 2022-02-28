package com.pjem.emprestimo.controller;

import com.pjem.emprestimo.model.Emprestimo;
import com.pjem.emprestimo.service.EmprestimoService;
import com.pjem.emprestimo.service.CadastroService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/emprestimo")
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoController extends CadastroService {

    EmprestimoService emprestimoService;
   // CadastroService cadastroService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Emprestimo> createEmprestimo(@RequestBody Emprestimo emprestimo) {
        return emprestimoService.save(emprestimo);
    }
    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(CadastroController.class);

    @GetMapping("/simples/{email}")
    public Mono<ResponseEntity<Emprestimo>> findByIdEmprestimoSimples(@PathVariable String email) {
        return emprestimoService.findByEmprestimoSimples(email)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/completo/{email}")
    public Mono<Object> findByIdEmprestimoCompleto(@PathVariable String email) {
        log.info("SOLICITAND EMPRESTIMO DENTRO DO EMPRSTIMO COM E-MAIL {}", email);
        return emprestimoService.findByEmprestimoCompleto(email)

                .map((emprestimo ) -> {
                    emprestimo.getCodigo();
                    emprestimo.getDatainicio();
                    emprestimo.getValoremprestimo();
                    emprestimo.getNumparcelas();


                    log.info("SOLICITAND DADOS DE EMPRESTIMO DENTRO DO CONTROLLER COM E-MAIL {}", email);
                    log.info("CODIGO -=> {}", emprestimo.getCodigo());
                    log.info("CODIGO -=> {}", emprestimo.getDatainicio());
                    log.info("CODIGO -=> {}", emprestimo.getValoremprestimo());
                    log.info("CODIGO -=> {}", emprestimo.getNumparcelas());

                    System.out.println(emprestimo.getCodigo());
                    System.out.println(emprestimo.getDatainicio());
                    System.out.println(emprestimo.getValoremprestimo());
                    System.out.println(emprestimo.getNumparcelas());
                    return null;

                })
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
