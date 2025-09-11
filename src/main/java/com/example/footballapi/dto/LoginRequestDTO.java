package com.example.footballapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @Email(message = "Formato de e-mail inválido")
        String email,
        @NotBlank
        String password
) {
}
