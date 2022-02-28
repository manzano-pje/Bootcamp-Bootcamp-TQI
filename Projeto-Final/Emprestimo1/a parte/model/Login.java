package com.pjem.emprestimo.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.validation.constraints.Email;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Login {

    @Id
    @Email(message="email inválido")
    private String email;

    @NotNull
    private String senha;

}

