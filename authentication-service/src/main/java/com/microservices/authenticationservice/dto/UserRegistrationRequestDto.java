package com.microservices.authenticationservice.dto;

import com.microservices.authenticationservice.utils.FieldPasswordRegex;
import com.microservices.authenticationservice.utils.FieldsValueMatch;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@FieldsValueMatch(
        field = "password",
        fieldMatch = "confirmPassword",
        message = "Passwords do not match!")
public class UserRegistrationRequestDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @FieldPasswordRegex(field = "password")
    private String password;

    private String confirmPassword;

    @NotEmpty
    private String email;

    private LocalDate birthday;
}
