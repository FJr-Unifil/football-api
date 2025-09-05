package com.example.footballapi.dto;

import com.example.footballapi.Position;

public record PlayerDTO(
        String name,
        String lastName,
        int age,
        int heightInCm,
        int weightInCm,
        Position position,
        long teamId,
        int annuallyWageInCents,
        int marketValueInCents
) {
}
