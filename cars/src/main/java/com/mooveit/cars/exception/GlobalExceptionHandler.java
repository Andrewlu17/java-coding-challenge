package com.mooveit.cars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCarNotFoundException(CarNotFoundException e){
        return new ResponseEntity<>(ErrorMessage.builder().message(e.getMessage()).code(400).build(), HttpStatus.BAD_REQUEST);
    }

}
