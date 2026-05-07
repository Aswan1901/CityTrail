package com.example.CityTrail;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String entity, Long id){
        super(entity + " with id " + id + " not found");
    }
}


