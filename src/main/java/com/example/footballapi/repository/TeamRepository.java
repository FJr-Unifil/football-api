package com.example.footballapi.repository;

import com.example.footballapi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Long, Team> {
}
