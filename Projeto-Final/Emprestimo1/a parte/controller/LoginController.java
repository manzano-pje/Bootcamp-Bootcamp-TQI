package com.pjem.emprestimo.controller;


import com.pjem.emprestimo.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping({"/"})
public class LoginController {
    @Autowired

    private LoginRepository login;
    public LoginController(LoginRepository loginRepository) {
        this.login = loginRepository;
    }

    private String cpf;
    private String email;
    private String senha;



/*
    public boolean verificaLogin(String cpf, String email, String senha){
        this.cpf   = cpf;
        this.email = email;
        this.senha = senha;

        ArrayList<Login> verifica = findById(cpf);

        return true;
    }
    private ResponseEntity<> findById(@PathVariable String id){
        return login.findById(id)
                .map(acesso -> ResponseEntity.ok().body(acesso))
                .orElse(ResponseEntity.notFound().build());
    }*/

}
