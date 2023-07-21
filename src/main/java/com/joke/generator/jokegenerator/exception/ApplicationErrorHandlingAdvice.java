package com.joke.generator.jokegenerator.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationErrorHandlingAdvice {
    @ExceptionHandler(ApiException.class)
    ResponseEntity<String> apiExceptionHandler(){
        return  ResponseEntity.badRequest().body("Something went wrong while calling joke api");
    }
}
