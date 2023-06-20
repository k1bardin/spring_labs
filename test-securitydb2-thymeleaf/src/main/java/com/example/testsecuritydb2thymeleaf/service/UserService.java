package com.example.testsecuritydb2thymeleaf.service;

import com.example.testsecuritydb2thymeleaf.dto.UserDto;
import com.example.testsecuritydb2thymeleaf.entity.User;

import java.util.List;

public interface UserService {
    void saveUser (UserDto userDto);
    User findUserByEmail (String email);
    List <UserDto> findAllUsers();
}
