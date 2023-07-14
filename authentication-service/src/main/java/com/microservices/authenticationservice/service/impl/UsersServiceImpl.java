package com.microservices.authenticationservice.service.impl;

import com.microservices.authenticationservice.entity.UserEntity;

public interface UsersServiceImpl {
    UserEntity findUserById(Long id);

    UserEntity createUser(UserEntity userEntity);
}
