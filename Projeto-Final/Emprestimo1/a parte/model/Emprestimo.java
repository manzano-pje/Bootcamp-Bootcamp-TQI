package com.pjem.emprestimo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName ="TB_Emprestimo")

public class Emprestimo {
	@javax.persistence.Id
	@Email(message = "E-mail inválido")
	@Column(name = "email", nullable = false)
	private String email;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@DynamoDBHashKey(attributeName = "codigo")
	private int	codigo;

	@CPF
	@NotEmpty
	@DynamoDBHashKey(attributeName = "cpf")
	private String cpf;

	@NotNull(message = "Valor do empréstimo nã opode ser vazio")
	@Digits(integer=6,fraction=2)
	@DynamoDBHashKey(attributeName = "valoremrprestimo")
	private float 	valoremprestimo;

	@NotNull(message = "Número de parcelas precisa ser maior que 1")
	@Range(min=1,max=60,message="A quantidade parcelas varia de 1 a 60")
	@DynamoDBHashKey(attributeName = "parcelas")
	private byte	parcelas;
	
	@NotNull(message = "Data de início não pode ser vazia")
	@FutureOrPresent(message = "A Data de início não pode ser anterior a data de hoje")
	@DynamoDBHashKey(attributeName = "datainicio")
	private String  datainicio;

}


