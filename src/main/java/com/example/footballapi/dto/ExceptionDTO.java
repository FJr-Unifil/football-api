package com.example.footballapi.dto;

import java.time.LocalDateTime;

public record ExceptionDTO(
        String name,
        String message,
        LocalDateTime timestamp
) {
}
