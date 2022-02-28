package com.pjem.emprestimo.repository;

import com.pjem.emprestimo.model.Cadastro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository      
public interface CadastroRepository
        extends CrudRepository<Cadastro, String> {


}
