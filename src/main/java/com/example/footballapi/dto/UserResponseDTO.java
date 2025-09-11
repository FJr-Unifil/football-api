package com.example.footballapi.dto;

import com.example.footballapi.model.Gender;

public record UserResponseDTO(
        String username,
        String email,
        int age,
        Gender gender,
        String city,
        String favoriteTeamName
) {
}
