package org.example.shop.exception;

public class ProductNotSavedException extends Exception {

    private static final String MESSAGE = "!!! Product was not saved.";

    public ProductNotSavedException() {
        super(MESSAGE);
    }
}
