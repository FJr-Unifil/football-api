package com.example.footballapi.service;

import com.example.footballapi.dto.UserDTO;
import com.example.footballapi.model.User;
import com.example.footballapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public void createUser(UserDTO data) {
        User user = new User(
                data.username(),
                data.email(),
                data.password(),
                data.team()
        );

       userRepository.save(user);
    }
}
