package com.example.footballapi.model;

import com.example.footballapi.Position;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "players")
@Data
public class Player {

    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int heightInCm;

    @Column(nullable = false)
    private int weightInCm;

    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    private Team team;

    @Column(nullable = false)
    private int annuallyWageInCents;

    @Column(nullable = false)
    private int marketValueInCents;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}
