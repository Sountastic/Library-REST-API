package com.project.library.api.services;

import com.project.library.api.domain.User;
import com.project.library.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(final Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }
}
