package com.kbe.shoppingapp.exception;

public class EmailAlreadyExistsException extends Exception {
    public EmailAlreadyExistsException() {
        super("Email already exists!");
    }
}
