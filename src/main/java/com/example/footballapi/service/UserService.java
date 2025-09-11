package com.example.footballapi.service;

import com.example.footballapi.dto.UserRequestDTO;
import com.example.footballapi.dto.UserResponseDTO;
import com.example.footballapi.model.User;
import com.example.footballapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public UserResponseDTO getUserResponseById(Long id) {
        User user = getUserById(id);

        return new UserResponseDTO(
                user.getUserRealUsername(),
                user.getEmail(),
                user.getAge(),
                user.getGender(),
                user.getCity(),
                user.getFavoriteTeamName()
        );
    }

    public void createUser(UserRequestDTO data) {
        User user = new User(data);

        validateUserData(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

       userRepository.save(user);
    }

    public void updateUser(User user, UserRequestDTO data) {
        User newUser = new User(data);

        validateUserData(newUser, user.getId());

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        newUser.setId(user.getId());

        userRepository.save(newUser);
    }

    public void deleteUser(User user) {
        user.setActive(false);

        userRepository.save(user);
    }

    private void validateUserData(User user) {
        Map<String, String> errors = new HashMap<>();

        if (userRepository.existsByEmail(user.getEmail())) {
            errors.put("email", "Email already exists with value [" + user.getEmail() + "]");
        }
        if (userRepository.existsByUsername(user.getUsername())) {
            errors.put("username", "Username already exists with value [" + user.getUsername() + "]");
        }

        if (!errors.isEmpty()) {
            throw new DataIntegrityViolationException("Invalid data: " + errors);
        }
    }

    private void validateUserData(User user, Long id) {
        Map<String, String> errors = new HashMap<>();

        if (userRepository.existsByEmailAndIdNot(user.getEmail(), id)) {
            errors.put("email", "Email already exists with value [" + user.getEmail() + "]");
        }
        if (userRepository.existsByUsernameAndIdNot(user.getUsername(), id)) {
            errors.put("username", "Username already exists with value [" + user.getUsername() + "]");
        }

        if (!errors.isEmpty()) {
            throw new DataIntegrityViolationException("Invalid data: " + errors);
        }
    }
}
