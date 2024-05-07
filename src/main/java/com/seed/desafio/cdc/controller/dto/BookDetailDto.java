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

import java.math.BigDecimal;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailDto {


    private String id;

    private String title;

    private Date createdAt;

    private String resume;

    private String summary;

    private BigDecimal price;

    private int numberPage;

    private Date datePublication;

    private String isbn;

    private String category;

    private String author;

    public static BookDetailDto of(Book book){
        return new BookDetailDto(book.getId(), book.getTitle(), book.getCreatedAt(), book.getResume(), book.getSummary(), book.getPrice(),
        book.getNumberPage(), book.getDatePublication(), book.getIsbn(), book.getCategory().getName(), book.getAuthor().getName());
    }
}
