package com.example.footballapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "players")
@Data
public class Player {

    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @Column(name = "height_in_cm",nullable = false)
    private int heightInCm;

    @Column(name = "weight_in_cm", nullable = false)
    private int weightInCm;

    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;

    @Column(name = "annually_wage_in_cents",nullable = false)
    private int annuallyWageInCents;

    @Column(name = "market_value_in_cents",nullable = false)
    private int marketValueInCents;

    @Column(name = "is_starter_player", nullable = false)
    private boolean isStarterPlayer = true;

    @Column(name = "is_on_bench", nullable = false)
    private boolean isOnBench = false;

    @Column(name = "is_not_related", nullable = false)
    private boolean isNotRelated = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
