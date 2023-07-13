package com.microservices.authenticationservice.service;

import com.microservices.authenticationservice.entity.UsersEntity;
import com.microservices.authenticationservice.enums.UserStatusEnum;
import com.microservices.authenticationservice.repository.UsersRepository;
import com.microservices.authenticationservice.service.impl.UsersServiceImpl;
import com.microservices.authenticationservice.utils.PasswordCoder;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersService implements UsersServiceImpl {

    private final UsersRepository usersRepository;

    @Autowired
    private final PasswordCoder passwordCoder;

    @Override
    public UsersEntity findUserById(Long id) {
        Optional<UsersEntity> user = usersRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public UsersEntity createUser(UsersEntity usersEntity) {
        UsersEntity user = new UsersEntity();
        user.setId(usersEntity.getId());
        user.setFirstname(usersEntity.getFirstname());
        user.setLastname(usersEntity.getLastname());
        user.setPassword(passwordCoder.encodePassword(usersEntity.getPassword()));
        user.setBirthday(usersEntity.getBirthday());
        user.setEmail(usersEntity.getEmail());
        user.setStatus(UserStatusEnum.ACTIVE);

        usersRepository.save(user);
        return user;
    }

    @PostConstruct
    public UsersEntity testGeneration() {
        UsersEntity user = new UsersEntity();
        user.setId(5L);
        user.setFirstname("Alexey");
        user.setLastname("Somov");
        user.setEmail("test@mail.ru");
        user.setPassword(passwordCoder.encodePassword("Should be encrypted"));
        user.setStatus(UserStatusEnum.ACTIVE);
        usersRepository.save(user);
        return user;
    }
}
