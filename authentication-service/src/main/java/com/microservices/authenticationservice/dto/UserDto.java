package com.microservices.authenticationservice.dto;

import com.microservices.authenticationservice.utils.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class UserDto {

    @NotNull
    private Long id;

    @ValidPassword
    private String password;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String email;

    private LocalDate birthday;
}
