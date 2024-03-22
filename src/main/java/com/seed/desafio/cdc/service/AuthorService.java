package com.seed.desafio.cdc.service;

import com.seed.desafio.cdc.controller.dto.AuthorCreateDto;
import com.seed.desafio.cdc.exceptions.BadRequestException;
import com.seed.desafio.cdc.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;
    public void create(AuthorCreateDto dto){
        if(repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new BadRequestException("já existe esse email na base de dados");
        }
        repository.save(dto.toModel());
    }
}
