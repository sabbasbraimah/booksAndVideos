package com.seiduAbbas.ecommerce.exception;

public class AccountNotFoundException  extends Exception {

    private String message;

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String message) {
        super(message);

    }
}