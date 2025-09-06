package com.example.footballapi.dto;

import com.example.footballapi.model.Team;

public record UserDTO(
        String username,
        String email,
        String password,
        Team team
) {
}
