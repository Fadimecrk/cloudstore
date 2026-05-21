package com.example.cloudstore;

import com.example.cloudstore.service.UserService;
import com.example.cloudstore.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CloudstoreApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {
    }

    @Test
    void testRegisterUser() {
        userService.registerUser("testuser", "test@example.com", "password123");
        assertTrue(userRepository.existsByUsername("testuser"));
    }

    @Test
    void testPasswordIsEncoded() {
        userService.registerUser("testuser2", "test2@example.com", "password123");
        var user = userRepository.findByUsername("testuser2").orElseThrow();
        assertTrue(passwordEncoder.matches("password123", user.getPassword()));
    }

    @Test
    void testDuplicateUsernameThrowsException() {
        userService.registerUser("testuser3", "test3@example.com", "password123");
        assertThrows(RuntimeException.class, () ->
                userService.registerUser("testuser3", "other@example.com", "password123")
        );
    }
}