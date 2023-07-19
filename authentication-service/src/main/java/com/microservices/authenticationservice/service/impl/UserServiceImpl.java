package com.microservices.authenticationservice.service.impl;

import com.microservices.authenticationservice.configuration.SecurityConfig;
import com.microservices.authenticationservice.dto.UserDto;
import com.microservices.authenticationservice.dto.UserRegistrationRequestDto;
import com.microservices.authenticationservice.entity.UserEntity;
import com.microservices.authenticationservice.enums.UserStatusEnum;
import com.microservices.authenticationservice.exception.ResourceNotFoundException;
import com.microservices.authenticationservice.exception.UserAlreadyExistException;
import com.microservices.authenticationservice.mapper.UserMapper;
import com.microservices.authenticationservice.repository.UserRepository;
import com.microservices.authenticationservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;
    private final UserMapper userMapper;


    @Override
    public UserDto findUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.userEntityToUserDto(user.get());
        } else {
            throw new ResourceNotFoundException("User not found with ID: " + id);
        }
    }

    @Override
    public UserDto createUser(UserRegistrationRequestDto request) {
        userRepository.findByEmail(request.getEmail())
                .ifPresent(user -> {
                    throw new UserAlreadyExistException("Email already in use");
                });

        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(securityConfig.passwordEncoder().encode((request.getPassword())));
        user.setBirthday(request.getBirthday());
        user.setEmail(request.getEmail());
        user.setStatus(UserStatusEnum.ACTIVE.name());

        userRepository.save(user);
        return userMapper.userEntityToUserDto(user);
    }
}
