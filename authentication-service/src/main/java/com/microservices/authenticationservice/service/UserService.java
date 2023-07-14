package com.microservices.authenticationservice.service;

import com.microservices.authenticationservice.configuration.SecurityConfig;
import com.microservices.authenticationservice.entity.UserEntity;
import com.microservices.authenticationservice.enums.UserStatusEnum;
import com.microservices.authenticationservice.exception.UserNotFoundException;
import com.microservices.authenticationservice.repository.UserRepository;
import com.microservices.authenticationservice.service.impl.UsersServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UsersServiceImpl {

    private final UserRepository userRepository;

    private final SecurityConfig securityConfig;


    @Override
    public UserEntity findUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        UserEntity user = new UserEntity();
        user.setId(userEntity.getId());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setPassword(securityConfig.encodePassword((userEntity.getPassword())));
        user.setBirthday(userEntity.getBirthday());
        user.setEmail(userEntity.getEmail());
        user.setStatus(UserStatusEnum.ACTIVE);

        userRepository.save(user);
        return user;
    }
}
