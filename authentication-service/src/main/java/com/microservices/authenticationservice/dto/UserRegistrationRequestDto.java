package com.microservices.authenticationservice.dto;

import com.microservices.authenticationservice.utils.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
public class UserRegistrationRequestDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @ValidPassword
    private String password;

    private String confirmPassword;

    @NotEmpty
    private String email;

    private LocalDate birthday;


}
