package com.mooveit.cars.exception;

public class CarNotFoundException extends Exception {
    private String message;

    public CarNotFoundException(String message) {
        super(message);
    }
}
