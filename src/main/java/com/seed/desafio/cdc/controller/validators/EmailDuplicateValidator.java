package com.seed.desafio.cdc.controller.validators;

import com.seed.desafio.cdc.controller.dto.AuthorCreateDto;
import com.seed.desafio.cdc.entity.Author;
import com.seed.desafio.cdc.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@AllArgsConstructor
public class EmailDuplicateValidator implements Validator {

    private final AuthorRepository authorRepository;
    @Override
    public boolean supports(Class<?> clazz) {
        return AuthorCreateDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        AuthorCreateDto dto = (AuthorCreateDto) target;
        Optional<Author> optionalAuthor = authorRepository.findByEmail(dto.getEmail());
        if(optionalAuthor.isPresent()){
            errors.rejectValue("email", "400",
                    "Esse email já existe na base: "+dto.getEmail());
        }

    }
}
