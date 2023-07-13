package com.microservices.authenticationservice.service.impl;

import com.microservices.authenticationservice.entity.UsersEntity;

public interface UsersServiceImpl {
    UsersEntity findUserById(Long id);

    UsersEntity createUser(UsersEntity usersEntity);
}
