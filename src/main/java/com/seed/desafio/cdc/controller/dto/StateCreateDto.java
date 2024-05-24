package com.seed.desafio.cdc.controller.dto;

import com.seed.desafio.cdc.controller.validators.UniqueValue;
import com.seed.desafio.cdc.entity.Country;
import com.seed.desafio.cdc.entity.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StateCreateDto {

    @NotNull
    @UniqueValue(domainClass = State.class, fieldName ="name", message = "nome do estado deve ser unico")
    private String name;

    @NotNull(message = "id do país não pode ser nullo")
    @NotEmpty(message = "id do país não pode ser vazio")
    private String countryId;

    public State toModel(){
        return new State(this.name, new Country(this.countryId));
    }
}
