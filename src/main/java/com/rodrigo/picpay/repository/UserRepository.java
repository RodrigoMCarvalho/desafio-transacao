package com.rodrigo.picpay.repository;

import com.rodrigo.picpay.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
