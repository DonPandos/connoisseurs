package com.microservices.authenticationservice.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FieldPasswordRegexValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldPasswordRegex {
    String message() default "invalid input of the field";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
