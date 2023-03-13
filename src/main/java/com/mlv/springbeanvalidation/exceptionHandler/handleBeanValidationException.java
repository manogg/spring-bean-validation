package com.mlv.springbeanvalidation.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class handleBeanValidationException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleException(MethodArgumentNotValidException ex){

     Map<String,String> errorMap=new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e->{
                    errorMap.put(e.getField(),e.getDefaultMessage());
                });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String,String> handleException(NoSuchElementException ex1){

        Map<String,String> errorMap2=new HashMap<>();

        errorMap2.put("errorMessage",ex1.getMessage());

        return errorMap2;
    }


}
