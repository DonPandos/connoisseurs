package com.microservices.authenticationservice.service;

import com.microservices.authenticationservice.dto.UserDto;
import com.microservices.authenticationservice.dto.UserRegistrationRequestDto;

import java.util.Optional;

public interface UsersService {
    UserDto findUserById(Long id);

    UserDto createUser(UserRegistrationRequestDto userRegistrationRequestDto);
}
