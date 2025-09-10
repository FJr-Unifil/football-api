package com.example.footballapi.service;

import com.example.footballapi.dto.UserRegisterDTO;
import com.example.footballapi.model.User;
import com.example.footballapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public void createUser(UserRegisterDTO data) {
        User user = new User(
                data.username(),
                data.email(),
                passwordEncoder.encode(data.password())
        );

       userRepository.save(user);
    }
}
