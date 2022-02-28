package com.pjem.emprestimo.repository;


import com.pjem.emprestimo.model.Emprestimo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan

public interface EmprestimoRepository extends CrudRepository<Emprestimo, String> {

}
