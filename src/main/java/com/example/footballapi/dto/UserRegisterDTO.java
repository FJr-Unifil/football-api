package com.example.footballapi.dto;

public record UserRegisterDTO(
        String username,
        String email,
        String password
) {
}
