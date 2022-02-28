package com.pjem.emprestimo.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.pjem.emprestimo.constants.EmprestimoConstant;

public class EmprestimoData {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration
                        (EmprestimoConstant.ENDPOINT_DYNAMO, EmprestimoConstant.REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("TB_Emprestimo2");

        Item emprestimo1 = new Item()
                .withPrimaryKey("email", "manzano.pje@gmail.com")
                .withInt("codigo", 1)
                .withFloat("valoremprestimo", 100.50F)
                .withString("datainicio", "11-11-2021")
                .withInt("numparcelas", 10 )
                .withString("cpf","06326651816");

        Item emprestimo2 = new Item()
                .withPrimaryKey("email", "andreajunqueira@gmail.com")
                .withInt("codigo", 2)
                .withFloat("valoremprestimo", 500.25F)
                .withString("datainicio", "21-01-2021")
                .withInt("numparcelas", 5 )
                .withString("cpf","25483926862");

        PutItemOutcome outcome1 = table.putItem(emprestimo1);
        PutItemOutcome outcome2 = table.putItem(emprestimo2);

    }

}
