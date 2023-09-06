package com.rodrigo.picpay.service;

import com.rodrigo.picpay.domain.dto.UserResponse;
import com.rodrigo.picpay.domain.entity.User;
import com.rodrigo.picpay.mapper.UserMapper;
import com.rodrigo.picpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.rodrigo.picpay.validator.UserValidator.verificarSeJaExiste;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public UserResponse createUser(User user) {
        verificarSeJaExiste(() -> repository.findByDocument(user.getDocument()), "CPF já cadastrado.");
        verificarSeJaExiste(() -> repository.findByEmail(user.getEmail()), "Email já cadastrado.");
        return UserMapper.toUserResponse(repository.save(user));
    }

    public List<UserResponse> getUsers() {
        return UserMapper.toListUserResponse(repository.findAll());
    }
}
