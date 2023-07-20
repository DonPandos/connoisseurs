package com.microservices.authenticationservice.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FieldPasswordRegexValidator implements ConstraintValidator<FieldPasswordRegex, String> {

    private final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    private String field;

    public void initialize(FieldPasswordRegex constraintAnnotation) {
        this.field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(String fieldValue, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        if (fieldValue != null) {
            Pattern pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(fieldValue);
            return match.matches();
        } else {
            return false;
        }
    }
}
