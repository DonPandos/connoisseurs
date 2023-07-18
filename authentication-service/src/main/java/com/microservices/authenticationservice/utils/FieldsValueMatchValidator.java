package com.microservices.authenticationservice.utils;

import jakarta.validation.ConstraintValidator;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

    private String field;
    private String fieldMatch;

    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object obj, jakarta.validation.ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(obj).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(obj).getPropertyValue(fieldMatch);

        if (fieldValue != null) return fieldValue.equals(fieldMatchValue);
        else return fieldMatchValue == null;
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
