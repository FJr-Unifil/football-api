package com.example.footballapi.dto;

import com.example.footballapi.model.Gender;

public record UserRequestDTO(
        String username,
        String email,
        String password,
        int age,
        Gender gender,
        String city,
        String favoriteTeamName
) {
}
