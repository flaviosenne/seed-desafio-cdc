package com.seed.desafio.cdc.controller.dto;


import com.seed.desafio.cdc.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookListDto {

    private String id;

    private String title;

    private Date createdAt;

    public static BookListDto of(Book book){
        return new BookListDto(book.getId(), book.getTitle(), book.getCreatedAt());
    }
}
