package com.microservices.authenticationservice.entity;

import com.microservices.authenticationservice.enums.UserStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users", schema = "public")
public class UserEntity {

    @Id
    private Long id;

    private String password;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    private LocalDate birthday;

    private String email;

    private UserStatusEnum status;
}
