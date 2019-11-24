package com.seiduAbbas.ecommerce.exception;

public class PurchaseOrderNotFoundException extends Exception {

    private String message;

    public PurchaseOrderNotFoundException() {
    }
    public PurchaseOrderNotFoundException(String message) {
        super(message);
    }
}
