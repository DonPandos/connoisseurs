package com.microservices.authenticationservice.mapper;

import com.microservices.authenticationservice.dto.UserDto;
import com.microservices.authenticationservice.entity.UserEntity;
import org.mapstruct.Mapper;

    @Mapper(componentModel = "spring")
    public interface UserMapper {
        UserEntity userDtoToUserEntity(UserDto userDto);
        UserDto userEntityToUserDto(UserEntity userEntity);
    }
