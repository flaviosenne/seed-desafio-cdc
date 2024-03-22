package com.seed.desafio.cdc.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ExceptionError {

    private String type;
    private Date timestamp;
    private String message;
}
