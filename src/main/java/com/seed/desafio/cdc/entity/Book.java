package com.seed.desafio.cdc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    @Column(name = "created_at")
    private Date createdAt;

    private String resume;

    private String summary;

    private BigDecimal price;

    @Column(name = "number_page")
    private int numberPage;

    @Column(name = "date_publication")
    private Date datePublication;

    private String isbn;

    @OneToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;

    @OneToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    public Book(){}

    public Book(String title, String resume, String summary, double price, int numberPage,
                String isbn, Date datePublication){
        Assert.notNull(title, "Título do livro não pode ser nullo");
        Assert.notNull(resume, "Resumo do livro não pode ser nullo");
        Assert.isTrue(price >= 20, "Preço deve ser no mínimo R$ 20,00");
        Assert.isTrue(numberPage >= 100, "Número de páginas deve ser no mínimo 100");
        Assert.notNull(isbn, "ISBN do livro não pode ser nullo");
        Assert.notNull(datePublication, "Data de publicação do livro não pode ser nullo");
        Assert.isTrue(datePublication.after(new Date()), "Data de publicação deve ser a frente que a data de agora");
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = BigDecimal.valueOf(price);
        this.numberPage = numberPage;
        this.isbn = isbn;
        this.datePublication = datePublication;
        this.createdAt = new Date();
    }

    public Book withAuthor(Author author){
        this.author = author;
        return this;
    }

    public Book withCategory(Category category){
        this.category = category;
        return this;
    }

}
