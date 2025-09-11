package com.example.footballapi.controller;

import com.example.footballapi.dto.UserRequestDTO;
import com.example.footballapi.dto.UserResponseDTO;
import com.example.footballapi.model.User;
import com.example.footballapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
        UserResponseDTO user = userService.getUserResponseById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@AuthenticationPrincipal User user, @Valid @RequestBody UserRequestDTO data) {
        userService.updateUser(user, data);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@AuthenticationPrincipal User user) {
        userService.deleteUser(user);

        return ResponseEntity.noContent().build();
    }
}
