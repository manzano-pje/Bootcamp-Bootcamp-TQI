package com.pjem.emprestimo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName ="TB_Cadastro2")


public class Cadastro {

    @DynamoDBHashKey
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty
    @CPF
    @DynamoDBAttribute(attributeName = "cpf")
    private String cpf;

    @NotEmpty
    @Size(min=4, max=50, message="O nome de ter entre 4 e 50 caracteres")
    @DynamoDBAttribute(attributeName = "nome")
    private String nome;

    @NotEmpty
    @Size(min=4, max=50, message="O endereço de ter entre 4 e 50 caracteres")
    @DynamoDBAttribute(attributeName = "endereco")
    private String endereco;

    @DynamoDBAttribute(attributeName = "complemento")
    private String complemento;

    @NotEmpty
    @DynamoDBAttribute(attributeName = "bairro")
    private String bairro;

    @NotEmpty
    @Size(min=8, max=8)
    @DynamoDBAttribute(attributeName = "cep")
    private String cep;

    @NotEmpty
    @Size(min=4, max=20, message="Cidade deve ter entre 4 e 20 caracteres")
    @DynamoDBAttribute(attributeName = "cidade")
    private String cidade;

    @NotEmpty
    @DynamoDBAttribute(attributeName = "uf")
    private String uf;

    @DynamoDBAttribute(attributeName = "rg")
    private String rg;

    @NotEmpty
    @Digits(integer=6,fraction=2,message="Apenas milhares e 2 casas após o ponto.")
    @DynamoDBAttribute(attributeName = "renda")
    private Float  renda;

    @NotEmpty
    @Size(min=8, max=30, message="O campo senha deve conter de 8 a 30 caracteres")
    @DynamoDBAttribute(attributeName = "senha")
    private String senha;

}
