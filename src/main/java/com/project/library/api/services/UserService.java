package com.project.library.api.services;

import com.project.library.api.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(final Long id);

    User saveUser(final User user);

    void deleteUserById(final Long id);
}
