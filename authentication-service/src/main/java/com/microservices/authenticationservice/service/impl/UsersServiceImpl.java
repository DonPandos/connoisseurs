package com.microservices.authenticationservice.service.impl;

import com.microservices.authenticationservice.dto.UserDto;
import com.microservices.authenticationservice.dto.UserRegistrationRequestDto;

public interface UsersServiceImpl {
    UserDto findUserById(Long id);

    UserDto createUser(UserRegistrationRequestDto userRegistrationRequestDto);
}
