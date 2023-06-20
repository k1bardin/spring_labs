package com.example.testsecuritydb2thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.testsecuritydb2thymeleaf.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail (String email);
}
