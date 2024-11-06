package me.sqsw.buildandroll.service;

import me.sqsw.buildandroll.model.User;

import java.util.Optional;

public interface UserService {
    User create(User user);
    Optional<User> getByUsername(String username);
    Optional<User> getById(Long id);
}
