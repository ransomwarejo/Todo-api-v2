package com.sogel.todo_api_v2.todo_api.config;


import com.sogel.todo_api_v2.todo_api.model.Role;
import com.sogel.todo_api_v2.todo_api.model.User;
import com.sogel.todo_api_v2.todo_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByEmail("superadmin@example.com").isEmpty()) {
            User superAdmin = new User();
            superAdmin.setUsername("Ransom");
            superAdmin.setEmail("superadmin@example.com");
            superAdmin.setRole(Role.ADMIN);
            superAdmin.setPassword("Test@2025");
            userRepository.save(superAdmin);
        }
    }
}
