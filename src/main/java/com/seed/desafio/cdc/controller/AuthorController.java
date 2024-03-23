package com.seed.desafio.cdc.controller;

import com.seed.desafio.cdc.controller.dto.AuthorCreateDto;
import com.seed.desafio.cdc.controller.validators.EmailDuplicateValidator;
import com.seed.desafio.cdc.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/author")
public class AuthorController {

    private final AuthorService authorService;

    private final EmailDuplicateValidator emailDuplicateValidator;
    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailDuplicateValidator);
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid AuthorCreateDto dto){
        authorService.create(dto);
        return ResponseEntity.status(200).build();
    }
}
