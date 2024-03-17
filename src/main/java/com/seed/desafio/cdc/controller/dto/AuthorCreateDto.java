package com.seed.desafio.cdc.controller.dto;


import com.seed.desafio.cdc.entity.Author;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreateDto {

    @NotNull(message = "O nome não pode ser nullo")
    private String name;

    @NotNull(message = "O email não pode ser nullo")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "o email está com formato inválido")
    private String email;

    @NotNull(message = "A descrição não pode ser nulla")
    @Length(max = 400, message = "A descrição não pode ser maior que 400 caracteres")
    private String description;

    public Author toModel(){
        return Author.builder()
                .email(this.email)
                .name(this.name)
                .createdAt(new Date())
                .description(this.description)
                .build();
    }
}
