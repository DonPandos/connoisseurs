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
}
