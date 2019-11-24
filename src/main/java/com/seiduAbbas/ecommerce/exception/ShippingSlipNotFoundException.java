package com.seiduAbbas.ecommerce.exception;

public class ShippingSlipNotFoundException extends Exception {

    private String message;

    public ShippingSlipNotFoundException() {
    }

    public ShippingSlipNotFoundException(String message) {
        super(message);
    }
}
