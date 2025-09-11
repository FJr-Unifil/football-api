package com.example.footballapi.dto;

import com.example.footballapi.model.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public record UserRequestDTO(
        @Size(min = 6, message = "O nome de usuário deve ter no mínimo 6 caracteres")
        String username,
        @Email(message = "Formato de e-mail inválido")
        String email,
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
        String password,
        @Range(min = 18, max = 100, message = "A idade deve estar entre 18 e 100 anos")
        int age,
        @NotNull(message = "Gender é obrigatório")
        Gender gender,
        @NotBlank
        String city,
        @NotBlank
        String favoriteTeamName
) {
}
