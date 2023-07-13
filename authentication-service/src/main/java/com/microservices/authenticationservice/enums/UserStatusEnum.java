package com.microservices.authenticationservice.enums;

public enum UserStatusEnum {
    ACTIVE("Активный пользователь"),
    DELETED("Удаленный пользователь");

    UserStatusEnum(String userStatus) {
    }
}
