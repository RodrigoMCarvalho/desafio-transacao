package com.rodrigo.picpay.repository;

import com.rodrigo.picpay.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByDocument(String cpf);
    Optional<User> findByEmail(String cpf);
}
