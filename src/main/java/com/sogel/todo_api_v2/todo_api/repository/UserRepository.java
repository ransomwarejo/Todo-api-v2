package com.sogel.todo_api_v2.todo_api.repository;

import com.sogel.todo_api_v2.todo_api.model.Task;
import com.sogel.todo_api_v2.todo_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
