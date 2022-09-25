package com.example.springSecurityTest.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    CommandLineRunner run(UserRepository userRepository) {
        return args -> {
            AppUser user = new AppUser(
                    "John",
                    "john@gmail.com",
                    "john_user",
                    passwordEncoder.encode("1234"),
                    "USER"
            );

            AppUser admin = new AppUser(
                    "Arnold",
                    "arnold@gmail.com",
                    "arnold_admin",
                    passwordEncoder.encode("1234"),
                    "ADMIN"
            );

            userRepository.saveAll(
                    List.of(user,admin)
            );
        };
    }
}
