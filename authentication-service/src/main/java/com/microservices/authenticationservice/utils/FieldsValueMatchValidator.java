package com.microservices.authenticationservice.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator implements ConstraintValidator<FieldsValueMatch, Object> {

    private String field;
    private String fieldMatch;

    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(obj).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(obj).getPropertyValue(fieldMatch);

        constraintValidatorContext.buildConstraintViolationWithTemplate("does not match " + fieldMatch)
                .addPropertyNode(field)
                .addConstraintViolation();

        if (fieldValue != null) return fieldValue.equals(fieldMatchValue);
        else return fieldMatchValue == null;
    }
}
