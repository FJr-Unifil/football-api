package com.example.footballapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
public class Team {

    @Id
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String stadiumName;

    @Column(nullable = false)
    private int stadiumCapacity;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    @Column(name = "founded_in", nullable = false)
    private LocalDate foundedIn;

    @Column(name = "social_media_followers", nullable = false)
    private int socialMediaFollowers;

    @JoinColumn(name = "player_id", referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Player> player;

    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();
}
