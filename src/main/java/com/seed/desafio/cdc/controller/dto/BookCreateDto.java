package com.seed.desafio.cdc.controller.dto;


import com.seed.desafio.cdc.controller.validators.UniqueValue;
import com.seed.desafio.cdc.entity.Author;
import com.seed.desafio.cdc.entity.Book;
import com.seed.desafio.cdc.entity.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateDto {


    @NotNull(message = "Título do livro não pode ser nullo")
    @UniqueValue(domainClass = Book.class, fieldName ="title", message = "titulo do livro deve ser unico")
    private String title;

    private Date createdAt;

    @NotNull(message = "Resumo do livro não pode ser nullo")
    @Length(max = 500, message = "Resumo do livro deve ter no máximo 500 caracteres")
    private String resume;

    private String summary;

    @Min(value = 20, message = "Preço deve ser no mínimo R$ 20,00")
    private double price;

    @Min(value = 100, message =  "Número de páginas deve ser no mínimo 100")
    private int numberPage;

    @NotNull(message = "Data de publicação do livro não pode ser nullo")
    private Date datePublication;

    @NotNull(message = "ISBN do livro não pode ser nullo")
    private String isbn;

    private String categoryId;

    private String authorId;

    public Book toModel(){
        Category category = new Category().withId(this.categoryId);
        Author author = new Author(this.authorId);
        return new Book(this.title, this.resume, this.summary, this.price,
                this.numberPage, this.isbn, this.datePublication, category, author);
    }
}
