package com.microservices.authenticationservice.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class CustomValidator implements ConstraintValidator<ValidPassword, String> {
    private String passwordConfirmationFieldName;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        this.passwordConfirmationFieldName = constraintAnnotation.passwordConfirmationFieldName();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }

        // Password validation using regex
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=])(?!.*\\s).{8,}$";
        boolean isPasswordValid = password.matches(passwordRegex);

        if (isPasswordValid) {
            // Check if password and password confirmation fields are equal
            Object containingObject = context.getClass();
            Class<?> containingClass = containingObject.getClass();
            String passwordConfirmationFieldValue;
            try {
                Field passwordConfirmationField = containingClass.getDeclaredField(passwordConfirmationFieldName);
                passwordConfirmationField.setAccessible(true);
                passwordConfirmationFieldValue = (String) passwordConfirmationField.get(containingObject);
            } catch (Exception e) {
                throw new IllegalArgumentException("Could not retrieve password confirmation field value", e);
            }

            return password.equals(passwordConfirmationFieldValue);
        }

        return false;
    }
}
