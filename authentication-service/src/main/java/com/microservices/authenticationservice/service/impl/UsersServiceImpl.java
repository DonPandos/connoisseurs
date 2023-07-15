package com.microservices.authenticationservice.service.impl;

import com.microservices.authenticationservice.dto.UserDto;
import com.microservices.authenticationservice.dto.UserRegistrationRequestDto;
import com.microservices.authenticationservice.entity.UserEntity;
import com.microservices.authenticationservice.exception.UserPasswordMissMatchException;

public interface UsersServiceImpl {
    UserDto findUserById(Long id);

    UserDto createUser(UserRegistrationRequestDto userRegistrationRequestDto);
}
