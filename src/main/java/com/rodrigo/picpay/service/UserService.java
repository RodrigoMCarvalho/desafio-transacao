package com.rodrigo.picpay.service;

import com.rodrigo.picpay.domain.entity.User;
import com.rodrigo.picpay.exception.NotFoundException;
import com.rodrigo.picpay.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.rodrigo.picpay.validator.UserValidator.checkIfResourceExists;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(User user) {
        checkIfResourceExists(() -> userRepository.findByDocument(user.getDocument()), "CPF já cadastrado.");
        checkIfResourceExists(() -> userRepository.findByEmail(user.getEmail()), "Email já cadastrado.");
        return userRepository.save(user);
    }

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não localizado"));
    }

    public List<User> getUsers() {
        return userRepository.findAll(Sort.by("name").ascending());
    }


}
