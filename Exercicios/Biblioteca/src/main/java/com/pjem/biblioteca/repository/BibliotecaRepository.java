package com.pjem.biblioteca.repository;

import com.pjem.biblioteca.document.*;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface BibliotecaRepository extends CrudRepository<Biblioteca, String> {
}
