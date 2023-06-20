package com.example.testsecuritydb2thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.testsecuritydb2thymeleaf.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName (String name);
}
