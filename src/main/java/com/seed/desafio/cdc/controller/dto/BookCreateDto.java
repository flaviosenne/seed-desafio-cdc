package com.seed.desafio.cdc.controller.dto;


import com.seed.desafio.cdc.controller.validators.UniqueValue;
import com.seed.desafio.cdc.entity.Author;
import com.seed.desafio.cdc.entity.Book;
import com.seed.desafio.cdc.entity.Category;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
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
    @Max(value = 500, message = "Resumo do livro deve ter no máximo 500 caracteres")
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


    @NotNull(message = "O nome não pode ser nullo")
    private String name;

    @NotNull(message = "O email não pode ser nullo")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "o email está com formato inválido")
    private String email;

    @NotNull(message = "A descrição não pode ser nulla")
    @Length(max = 400, message = "A descrição não pode ser maior que 400 caracteres")
    private String description;

    private String categoryId;

    private String authorId;

    public Book toModel(){
        return new Book(this.title, this.resume, this.summary, this.price, this.numberPage, this.isbn, this.datePublication)
                .withAuthor(Author.builder().id(this.authorId).build())
                .withCategory(Category.builder().id(this.categoryId).build());
    }
}
