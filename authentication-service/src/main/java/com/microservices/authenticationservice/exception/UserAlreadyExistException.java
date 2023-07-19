package com.microservices.authenticationservice.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message) {
        super(message);
    }

}
