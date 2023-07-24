package com.microservices.authenticationservice.exception;

public class FieldDoNotMatch extends RuntimeException{
    public FieldDoNotMatch(String message) {
        super(message);
    }
}
