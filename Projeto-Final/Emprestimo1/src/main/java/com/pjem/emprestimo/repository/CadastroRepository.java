package com.pjem.emprestimo.repository;

import com.pjem.emprestimo.model.Cadastro;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
public interface CadastroRepository extends CrudRepository<Cadastro, String> {

}
