package com.seed.desafio.cdc.service;

import com.seed.desafio.cdc.controller.dto.AuthorCreateDto;
import com.seed.desafio.cdc.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;
    public void create(AuthorCreateDto dto){
        repository.save(dto.toModel());
    }
}
