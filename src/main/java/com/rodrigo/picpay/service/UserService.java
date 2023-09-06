package com.rodrigo.picpay.service;

import com.rodrigo.picpay.domain.entity.User;
import com.rodrigo.picpay.domain.dto.UserRequest;
import com.rodrigo.picpay.domain.dto.UserResponse;
import com.rodrigo.picpay.exception.InvalidUserDataDomainException;
import com.rodrigo.picpay.mapper.UserMapper;
import com.rodrigo.picpay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public UserResponse createUser(UserRequest request) {
        User user = UserMapper.toUser(request);
        if(repository.findByDocument(request.document()).isPresent()) {
            throw new InvalidUserDataDomainException("CPF já cadastrado.");
        }
        if(repository.findByEmail(request.email()).isPresent()) {
            throw new InvalidUserDataDomainException("Email já cadastrado.");
        }
        return UserMapper.toUserResponse(repository.save(user));
    }

    public List<UserResponse> getUsers() {
        return UserMapper.toListUserResponse(repository.findAll());
    }
}
