package com.microservices.authenticationservice.service;

import com.microservices.authenticationservice.configuration.SecurityConfig;
import com.microservices.authenticationservice.dto.UserDto;
import com.microservices.authenticationservice.dto.UserRegistrationRequestDto;
import com.microservices.authenticationservice.entity.UserEntity;
import com.microservices.authenticationservice.enums.UserStatusEnum;
import com.microservices.authenticationservice.exception.AlreadyExistsException;
import com.microservices.authenticationservice.exception.UserNotFoundException;
import com.microservices.authenticationservice.exception.UserPasswordMissMatchException;
import com.microservices.authenticationservice.mapper.UserMapper;
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
    private final UserMapper userMapper;


    @Override
    public UserDto findUserById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(userMapper::userEntityToUserDto)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }


    @Override
    public UserDto createUser(UserRegistrationRequestDto request) {

        if (request.getPassword() != request.getConfirmPassword()) {
            throw new UserPasswordMissMatchException("Password do not match");
        }

        Optional<UserEntity> userEmail = userRepository.findByEmail(request.getEmail());
        if (userEmail.isPresent()) {
            throw new AlreadyExistsException("Email already in use");
        }

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
