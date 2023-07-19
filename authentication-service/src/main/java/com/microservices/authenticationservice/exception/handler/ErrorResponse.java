package com.microservices.authenticationservice.exception.handler;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private String details;
    private List<ValidationException> validationExceptions;

    public ErrorResponse(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.validationExceptions = new ArrayList<>();
    }

    public void addValidationException(String fieldName, String message) {
        this.validationExceptions.add(new ValidationException(fieldName, message));
    }
}
