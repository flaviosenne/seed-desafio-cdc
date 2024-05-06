package com.seed.desafio.cdc.controller.validators;

import com.seed.desafio.cdc.controller.dto.BookCreateDto;
import com.seed.desafio.cdc.entity.Category;
import com.seed.desafio.cdc.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CategoryExistsValidator implements Validator {

    private final CategoryRepository repository;
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
        Optional<Category> optionalCategory = repository.findById(dto.getCategoryId());
        if(optionalCategory.isEmpty()){
            errors.rejectValue("categoryId", "400",
                    "Essa categoria não existe na base: "+dto.getCategoryId());
        }

    }
}
