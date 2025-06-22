package org.example.userservice.service;

import org.example.userservice.dto.LoginRequestDTO;
import org.example.userservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    void deleteUser(Long id);

    User updateUser(Long id, User updatedUser);

    public String loginUser(LoginRequestDTO request);
}