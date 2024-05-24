package com.seed.desafio.cdc.controller;

import com.seed.desafio.cdc.controller.dto.StateCreateDto;
import com.seed.desafio.cdc.controller.validators.CountryExistsValidator;
import com.seed.desafio.cdc.entity.State;
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
@RequestMapping(value = "/state")
public class StateController {

    @PersistenceContext
    private EntityManager entityManager;

    private CountryExistsValidator countryExistsValidator;

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(countryExistsValidator);

    }
    @Transactional
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid StateCreateDto dto){;
        State entity = dto.toModel();
        entityManager.persist(entity);
        return ResponseEntity.status(201).build();
    }
}
