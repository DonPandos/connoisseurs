package com.microservices.authenticationservice.utils;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldsValueMatchValidator
        implements ConstraintValidator<FieldsValueMatch, Object> {

    private String field;
    private String fieldMatch;

    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    public boolean isValid(Object value,
                           ConstraintValidatorContext context) {

        Object fieldValue = new BeanWrapperImpl(value)
                .getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value)
                .getPropertyValue(fieldMatch);

        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
/*    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";


        if (fieldValue != null && fieldMatchValue != null && fieldValue instanceof String && fieldMatchValue instanceof String) {
            String passwordValue = (String) fieldValue;
            String passwordConfirmValue = (String) fieldMatchValue;

            Pattern pattern = Pattern.compile(regex);
            Matcher passwordMatcher = pattern.matcher(passwordValue);
            Matcher confirmMatcher = pattern.matcher(passwordConfirmValue);

            return passwordMatcher.matches() && confirmMatcher.matches() && passwordValue.equals(passwordConfirmValue);
        } else {
            return false;
        }
    }*/
}
