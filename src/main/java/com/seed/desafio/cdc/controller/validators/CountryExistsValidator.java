package com.seed.desafio.cdc.controller.validators;

import com.seed.desafio.cdc.controller.dto.StateCreateDto;
import com.seed.desafio.cdc.entity.Country;
import com.seed.desafio.cdc.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CountryExistsValidator implements Validator {


    private CountryRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return StateCreateDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        StateCreateDto dto = (StateCreateDto) target;
        Optional<Country> optionalCategory = repository.findById(dto.getCountryId());
        if(optionalCategory.isEmpty()){
            errors.rejectValue("countryId", "400",
                    "Esse país não existe na base: "+dto.getCountryId());
        }
    }
}
