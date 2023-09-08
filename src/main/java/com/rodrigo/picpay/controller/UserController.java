package com.rodrigo.picpay.controller;

import com.rodrigo.picpay.domain.dto.UserRequest;
import com.rodrigo.picpay.domain.dto.UserResponse;
import com.rodrigo.picpay.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.rodrigo.picpay.mapper.UserMapper.toUser;
import static com.rodrigo.picpay.mapper.UserMapper.toUserResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = service.createUser(toUser(userRequest));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(userResponse.id())
                .toUri();
        return ResponseEntity.created(uri).body(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(toUserResponse(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }
}
