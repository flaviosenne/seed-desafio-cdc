package com.seed.desafio.cdc.controller;

import com.seed.desafio.cdc.controller.dto.AuthorCreateDto;
import com.seed.desafio.cdc.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/author")
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid AuthorCreateDto dto){
        authorService.create(dto);
        return ResponseEntity.status(200).build();
    }
}
