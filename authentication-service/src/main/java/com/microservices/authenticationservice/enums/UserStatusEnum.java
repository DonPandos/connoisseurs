package com.microservices.authenticationservice.enums;

public enum UserStatusEnum {
    ACTIVE("Active user"),
    DELETED("Deleted User");

    UserStatusEnum(String userStatus) {
    }
}
