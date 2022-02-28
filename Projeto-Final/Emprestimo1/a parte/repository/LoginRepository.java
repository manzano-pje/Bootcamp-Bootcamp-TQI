package com.pjem.emprestimo.repository;

import com.pjem.emprestimo.model.Login;
import org.springframework.data.repository.CrudRepository;


public interface LoginRepository extends
        CrudRepository<Login, String> {
}
