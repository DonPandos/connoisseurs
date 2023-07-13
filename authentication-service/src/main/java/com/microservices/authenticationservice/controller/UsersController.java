package com.microservices.authenticationservice.controller;

import com.microservices.authenticationservice.entity.UsersEntity;
import com.microservices.authenticationservice.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("users")
@AllArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("{id}")
    public ResponseEntity<UsersEntity> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.findUserById(id));
    }

    @PostMapping("create")
    public ResponseEntity<UsersEntity> createUser(@RequestBody UsersEntity usersEntity) {
        return ResponseEntity.ok(usersService.createUser(usersEntity));
    }

}
