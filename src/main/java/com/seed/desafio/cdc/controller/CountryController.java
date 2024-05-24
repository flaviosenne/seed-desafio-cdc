package com.seed.desafio.cdc.controller;

import com.seed.desafio.cdc.controller.dto.CountryCreateDto;
import com.seed.desafio.cdc.entity.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/country")
public class CountryController {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CountryCreateDto dto){;
        Country entity = dto.toModel();
        entityManager.persist(entity);
        return ResponseEntity.status(201).build();
    }
}
