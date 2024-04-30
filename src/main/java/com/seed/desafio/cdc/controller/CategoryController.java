package com.seed.desafio.cdc.controller;


import com.seed.desafio.cdc.controller.dto.CategoryCreateDto;
import com.seed.desafio.cdc.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/category")
public class CategoryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> create(@RequestBody @Valid CategoryCreateDto dto){
        Category entity = dto.toModel();
        entityManager.persist(entity);
        return ResponseEntity.ok().build();
    }
}
