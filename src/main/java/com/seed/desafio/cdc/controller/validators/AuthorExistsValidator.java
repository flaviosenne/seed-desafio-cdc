package com.seed.desafio.cdc.controller.validators;

import com.seed.desafio.cdc.controller.dto.AuthorCreateDto;
import com.seed.desafio.cdc.controller.dto.BookCreateDto;
import com.seed.desafio.cdc.entity.Author;
import com.seed.desafio.cdc.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@AllArgsConstructor
public class AuthorExistsValidator implements Validator {

    private final AuthorRepository repository;
    @Override
    public boolean supports(Class<?> clazz) {
        return BookCreateDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        BookCreateDto dto = (BookCreateDto) target;
        Optional<Author> optionalAuthor = repository.findById(dto.getAuthorId());
        if(optionalAuthor.isEmpty()){
            errors.rejectValue("authorId", "400",
                    "Esse autor não existe na base: "+dto.getAuthorId());
        }

    }
}
