package com.rodrigo.picpay.controller;

import com.rodrigo.picpay.domain.dto.UserRequest;
import com.rodrigo.picpay.domain.dto.UserResponse;
import com.rodrigo.picpay.mapper.UserMapper;
import com.rodrigo.picpay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(service.createUser(UserMapper.toUser(userRequest)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }
}
