package com.pjem.emprestimo.repository;

import com.pjem.emprestimo.model.Emprestimo;
import org.springframework.data.repository.CrudRepository;

public interface EmprestimoRepository
        extends CrudRepository<Emprestimo, String> {
}
