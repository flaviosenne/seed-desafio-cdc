package com.seed.desafio.cdc.controller.exceptions;

import com.seed.desafio.cdc.exceptions.BadRequestException;
import com.seed.desafio.cdc.exceptions.NotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class ExceptionErrorHandler {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=utf-8";
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpEntity<ExceptionError> handlerValidationException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        ExceptionError message = new ExceptionError("Parâmetros inválidos", new Date(),fieldErrors.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", ")));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public HttpEntity<ExceptionError> handlerBadRequestException(BadRequestException ex) {
        ExceptionError message = new ExceptionError("Parâmetros inválidos", new Date(),ex.getMessage());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public HttpEntity<ExceptionError> handlerNotFoundException(NotFoundException ex) {
        ExceptionError message = new ExceptionError("Registro não encontrado", new Date(),ex.getMessage());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public HttpEntity<ExceptionError> handlerNotFoundException(NoResourceFoundException ex) {
        ExceptionError message = new ExceptionError("Registro não encontrado", new Date(),ex.getMessage());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public HttpEntity<ExceptionError> handleIllegalArgumentException(IllegalArgumentException ex) {
        ExceptionError message = new ExceptionError("Parâmetros inválidos", new Date(),ex.getMessage());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public HttpEntity<ExceptionError> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ExceptionError message = new ExceptionError("Parâmetros inválidos", new Date(),ex.getMessage());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(CONTENT_TYPE, APPLICATION_JSON_CHARSET_UTF_8);
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.BAD_REQUEST);
    }
}
