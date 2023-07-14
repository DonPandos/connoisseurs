package com.microservices.authenticationservice.mapper;

import com.microservices.authenticationservice.dto.UserDto;
import com.microservices.authenticationservice.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    UserDto UserEntityToUserDto(UserEntity userEntity);

}
