package com.seiduAbbas.ecommerce.exception;

public class CustomerNotFoundException  extends Exception{

    private String message;

    public CustomerNotFoundException() {
    }
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
