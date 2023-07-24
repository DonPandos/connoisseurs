package com.microservices.authenticationservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserLoginRequestDto {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;
}
