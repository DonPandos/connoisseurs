package com.microservices.authenticationservice.utils;

import jakarta.validation.ConstraintValidator;
import org.springframework.beans.BeanWrapperImpl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FieldPasswordRegexValidator implements ConstraintValidator<FieldPasswordRegex, Object> {

    private String field;

    public void initialize(FieldPasswordRegex constraintAnnotation) {
        this.field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(Object obj, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(obj).getPropertyValue(field);
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
        if (fieldValue != null) {
            String passwordValue = (String) fieldValue;
            Pattern pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(passwordValue);
            if (match.find()) {
                return true;
            } else return false;
        } else return false;
    }
}
