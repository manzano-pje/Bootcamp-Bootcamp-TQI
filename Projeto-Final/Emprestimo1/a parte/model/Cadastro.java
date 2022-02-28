package com.pjem.emprestimo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName ="TB_Cadastro")

public class Cadastro {
    @javax.persistence.Id
    @Email(message = "E-mail inválido")
    @Column(name = "email", nullable = false)
    private String email;


    @NotEmpty
    @CPF
    @DynamoDBHashKey(attributeName = "cpf")
    private String cpf;

    @NotEmpty
    @Size(min=4, max=50, message="O nome de ter entre 4 e 50 caracteres")
    @DynamoDBHashKey(attributeName = "nome")
    private String nome;

    @NotEmpty
    @Size(min=4, max=50, message="O endereço de ter entre 4 e 50 caracteres")
    @DynamoDBHashKey(attributeName = "endereco")
    private String endereco;

    @DynamoDBHashKey(attributeName = "complemento")
    private String complemento;

    @NotEmpty
    @DynamoDBHashKey(attributeName = "bairro")
    private String bairro;

    @NotEmpty
    @Size(min=8, max=8)
    @DynamoDBHashKey(attributeName = "cep")
    private String cep;

    @NotEmpty
    @Size(min=4, max=20, message="Cidade deve ter entre 4 e 20 caracteres")
    @DynamoDBHashKey(attributeName = "cidade")
    private String cidade;

    @NotEmpty
    @DynamoDBHashKey(attributeName = "uf")
    private String uf;

    @DynamoDBHashKey(attributeName = "rg")
    private String rg;

    @NotEmpty
    @Digits(integer=6,fraction=2,message="Apenas milhares e 2 casas após o ponto.")
    @DynamoDBHashKey(attributeName = "renda")
    private Float  renda;

    @NotEmpty
    @Size(min=8, max=30, message="O campo senha deve conter de 8 a 30 caracteres")
    @DynamoDBHashKey(attributeName = "senha")
    private String senha;

}