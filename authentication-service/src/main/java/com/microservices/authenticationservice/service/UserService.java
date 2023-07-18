package com.microservices.authenticationservice.service;

import com.microservices.authenticationservice.dto.UserDto;
import com.microservices.authenticationservice.dto.UserRegistrationRequestDto;

public interface UserService {
    UserDto findUserById(Long id);

    UserDto createUser(UserRegistrationRequestDto userRegistrationRequestDto);
}
