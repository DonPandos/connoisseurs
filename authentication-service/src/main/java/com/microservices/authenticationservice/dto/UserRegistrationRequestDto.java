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
@FieldPasswordRegex(
        field = "password",
        message = "The password field must contain at least 8 Latin characters, 1 lowercase, and 1 uppercase letter."
)
public class UserRegistrationRequestDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private String password;

    private String confirmPassword;

    @NotEmpty
    private String email;

    private LocalDate birthday;


}
