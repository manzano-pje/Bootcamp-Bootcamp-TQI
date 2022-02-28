package com.pjem.emprestimo.service;

//import com.pjem.emprestimo.model.Cadastro;
import com.pjem.emprestimo.model.Emprestimo;
import com.pjem.emprestimo.repository.EmprestimoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoService {
    EmprestimoRepository emprestimoRepository;
    //CadastroRepository cadastroRepository;

    public Mono<Emprestimo> findByEmprestimoSimples(String emprestimo){
        /* relatório smples
           código do empréstimo (emprestimo -> codigo)
           valor (emprestimo -> valoremprestimo)
           quantidade de parcelas (emprestimo -> numparcelas)
         */
        return  Mono.justOrEmpty(this.emprestimoRepository.findById(emprestimo));
    }

    public Mono<Emprestimo> findByEmprestimoCompleto(String emprestimo){
        /* Relatório detalhado
        código do empréstimo (emprestimo -> codigo)
        valor (emprestimo -> valoremprestimo)
        Quantidade de parcelas (emprestimo -> numparcelas)
        data da 1º parcela (emprestimo -> datainicio)
        e-mail (cadastro -> email)
        Renda (cadastro -> valorrenda)

         */
        return  Mono.justOrEmpty(this.emprestimoRepository.findById(emprestimo));
    }

    public Mono<Emprestimo> save(Emprestimo emprestimo){
        return  Mono.justOrEmpty(this.emprestimoRepository.save(emprestimo));
    }

}
