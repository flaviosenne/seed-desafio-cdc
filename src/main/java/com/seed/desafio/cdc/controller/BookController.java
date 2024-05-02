package com.seed.desafio.cdc.controller;

import com.seed.desafio.cdc.controller.dto.BookCreateDto;
import com.seed.desafio.cdc.controller.validators.AuthorExistsValidator;
import com.seed.desafio.cdc.controller.validators.CategoryExistsValidator;
import com.seed.desafio.cdc.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/book")
public class BookController {

    private final AuthorExistsValidator authorExistsValidator;
    private final CategoryExistsValidator categoryExistsValidator;

    @PersistenceContext
    private final EntityManager entityManager;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(authorExistsValidator);
        binder.addValidators(categoryExistsValidator);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid BookCreateDto dto){
        Book entity = dto.toModel();
        entityManager.persist(entity);
        return ResponseEntity.status(201).build();
    }
}
