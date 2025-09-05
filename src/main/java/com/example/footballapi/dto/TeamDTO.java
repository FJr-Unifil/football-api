package com.example.footballapi.dto;

import java.time.LocalDate;

public record TeamDTO(
        String name,
        String stadiumName,
        int stadiumCapacity,
        String city,
        String country,
        LocalDate foundedIn,
        int socialMediaFollowers
) {
}
