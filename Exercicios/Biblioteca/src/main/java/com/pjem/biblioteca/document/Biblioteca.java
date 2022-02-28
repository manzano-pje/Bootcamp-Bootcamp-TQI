package com.pjem.biblioteca.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName ="Tb_Biblioteca")

public class Biblioteca {
    public String getId() {
        return isbn;
    }
    public void setId(String id) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEstilo() {
        return estilo;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public int getPaginas() {
        return paginas;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getPublicacao() {
        return publicacao;
    }
    public void setPublicacao(int publicacao) {
        this.publicacao = publicacao;
    }

    @Id
    @DynamoDBHashKey (attributeName = "isbn")
    private String isbn;

    @DynamoDBAttribute (attributeName = "titulo")
    private String titulo;

    @DynamoDBAttribute (attributeName = "autor")
    private String autor;

    @DynamoDBAttribute (attributeName = "estilo")
    private String estilo;

    @DynamoDBAttribute (attributeName = "paginas")
    private int paginas;

    @DynamoDBAttribute (attributeName = "publicacao")
    private int publicacao;

    public Biblioteca(String id, String titulo, String autor, String estilo, int paginas, int publicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.estilo = estilo;
        this.paginas = paginas;
        this.publicacao = publicacao;
    }
}
