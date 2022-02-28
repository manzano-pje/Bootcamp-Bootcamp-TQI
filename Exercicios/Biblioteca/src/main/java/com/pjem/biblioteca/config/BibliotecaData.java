package com.pjem.biblioteca.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static com.pjem.biblioteca.constants.BibliotecaConstants.ENDPOINT_DYNAMO;
import static com.pjem.biblioteca.constants.BibliotecaConstants.REGION_DYNAMO;

public class BibliotecaData {
    public static void main(String[] args) throws Exception{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Tb_Biblioteca");

        Item livro1 = new Item()
                .withPrimaryKey("isbn", "85-7605-019-6")
                .withString("titulo", "Java: Como programar")
                .withString("autor", "Deitel H.M.")
                .withString("estilo", "Linguagem de programação")
                .withNumber("paginas", 1110)
                .withNumber("publicacao", 2006);

        Item livro2 = new Item()
                .withPrimaryKey("isbn", "978-85-7881-232-4")
                .withString("titulo", "10 chocolates para o sucesso")
                .withString("autor", "Ademir S Stein e Minoru Kimizuka")
                .withString("estilo", "Negócios")
                .withNumber("paginas", 136)
                .withNumber("publicacao", 2014);

        Item livro3 = new Item()
                .withPrimaryKey("isbn", "978-85-254-0954-9")
                .withString("titulo", "Pomba enamorada ou uma história de amor e outros contos escolhidos")
                .withString("autor", "Lygia Fagundes Telles")
                .withString("estilo", "Romance")
                .withNumber("paginas", 176)
                .withNumber("publicacao", 2023);

        Item livro4 = new Item()
                .withPrimaryKey("isbn", "85-262-2130-2")
                .withString("titulo", "Novo Bezerra Matemática")
                .withString("autor", "Manoel Jairo Bezerra e José Carlos Putnoki -JOTA")
                .withString("estilo", "Educação")
                .withNumber("paginas", 583)
                .withNumber("publicacao", 1997);

        PutItemOutcome outcome1 = table.putItem(livro1);
        PutItemOutcome outcome2 = table.putItem(livro2);
        PutItemOutcome outcome3 = table.putItem(livro3);
        PutItemOutcome outcome4 = table.putItem(livro4);
    }

}
