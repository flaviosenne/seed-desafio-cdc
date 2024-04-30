package com.seed.desafio.cdc.controller.dto;


import com.seed.desafio.cdc.controller.validators.UniqueValue;
import com.seed.desafio.cdc.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCreateDto {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName ="name", message = "nome da categoria deve ser unica")
    @NotNull(message = "O nome não pode ser nullo")
    private String name;

    public Category toModel(){
        return new Category(this.name);
    }
}
