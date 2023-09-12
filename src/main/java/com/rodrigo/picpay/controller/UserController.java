package com.rodrigo.picpay.controller;

import com.rodrigo.picpay.domain.dto.UserRequest;
import com.rodrigo.picpay.domain.dto.UserResponse;
import com.rodrigo.picpay.domain.entity.User;
import com.rodrigo.picpay.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.rodrigo.picpay.mapper.UserMapper.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        User userResponse = service.createUser(toUser(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(toUserResponse(userResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(toUserResponse(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<User> users = service.getUsers();
        return Optional.ofNullable(users)
                .map(user -> ResponseEntity.ok(toListUserResponse(user)))
                .orElse(ResponseEntity.noContent().build());

    }
}
