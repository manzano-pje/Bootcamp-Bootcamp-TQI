package com.pjem.emprestimo.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.pjem.emprestimo.constants.CadastroConstant;

public class CadastroData {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration
                        (CadastroConstant.ENDPOINT_DYNAMO, CadastroConstant.REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("TB_Cadastro2");

        Item cadastro1 = new Item()
                .withPrimaryKey("email", "manzano.pje@gmail.com")
                .withString("nome", "Paulo Jose Elias Manzano")
                .withString("cpf", "25483926862")
                .withString("rg", "14729857x" )
                .withString("endereco","R. Antonio Rosendo de Lima, 160")
                .withString("complemento", "casa 01")
                .withString("bairro", "Quatinga")
                .withString("cidade", "Mogi das Cruzes")
                .withString("uf", "SP")
                .withString("cep","08751-610")
                .withFloat( "renda", 1400.50F )
                .withString("senha","123456789");

        Item cadastro2 = new Item()
                .withPrimaryKey("email", "andreajunqueira@gmail.com")
                .withString("nome", "Andrea Junqueira Manzano")
                .withString("cpf", "06326651816")
                .withString("rg", "" )
                .withString("endereco","R. Antonio Rosendo de Lima, 160")
                .withString("complemento", "casa 01")
                .withString("bairro", "Quatinga")
                .withString("cidade", "Mogi das Cruzes")
                .withString("uf", "SP")
                .withString("cep","08751-610")
                .withFloat( "renda", 2250.50F )
                .withString("senha","21011967");

        PutItemOutcome outcome1 = table.putItem(cadastro1);
        PutItemOutcome outcome2 = table.putItem(cadastro2);
    }
}
