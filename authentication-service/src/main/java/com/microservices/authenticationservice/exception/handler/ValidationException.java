package com.microservices.authenticationservice.exception.handler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException {
    private String fieldName;
    private String message;

    public ValidationException(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
