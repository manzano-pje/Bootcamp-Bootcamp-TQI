package com.pjem.emprestimo.service;

import com.pjem.emprestimo.model.Cadastro;
import com.pjem.emprestimo.repository.CadastroRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;


import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository ;
        private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(CadastroService.class);

   public Optional<Cadastro> findByCadastro(String email){
       log.info("SOLICITAND CADASTRO DENTRO DO SERVICE COM E-MAIL {}", email);

       return  cadastroRepository.findById(email);
   }

    public Mono<Cadastro> save(Cadastro cadastro){
       return  Mono.justOrEmpty(this.cadastroRepository.save(cadastro));
    }

    public Mono<Boolean> deletebyCadastro(String cadastro) {
        cadastroRepository.deleteById(cadastro);
        return Mono.just(true);
    }

    public Cadastro updateCadastro(String email, Cadastro cadastro) {
        Optional<Cadastro> cadastroOptional =
                cadastroRepository.findById(email);
        if(cadastroOptional.isEmpty()) {
            throw new RuntimeException("Não existe cadastro com este e-mail");
        }
        BeanUtils.copyProperties(cadastro, cadastroOptional.get());
        return cadastroRepository.save(cadastroOptional.get());
    }

}
