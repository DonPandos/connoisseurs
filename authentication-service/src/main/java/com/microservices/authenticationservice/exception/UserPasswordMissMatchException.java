package com.microservices.authenticationservice.exception;

public class UserPasswordMissMatchException extends RuntimeException{
    public UserPasswordMissMatchException(String message) {
        super(message);
    }
}
