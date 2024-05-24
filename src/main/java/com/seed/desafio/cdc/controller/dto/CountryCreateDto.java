package com.seed.desafio.cdc.controller.dto;

import com.seed.desafio.cdc.controller.validators.UniqueValue;
import com.seed.desafio.cdc.entity.Country;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountryCreateDto {

    @NotNull(message = "nome do stado não pode ser null")
    @NotEmpty(message = "nome do stado não pode ser vazio")
    @UniqueValue(domainClass = Country.class, fieldName ="name", message = "nome do país deve ser unico")
    private String name;

    public Country toModel(){
        return new Country(null, this.name);
    }
}
