package com.sogel.todo_api_v2.todo_api.service;


import com.sogel.todo_api_v2.todo_api.model.User;
import com.sogel.todo_api_v2.todo_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
