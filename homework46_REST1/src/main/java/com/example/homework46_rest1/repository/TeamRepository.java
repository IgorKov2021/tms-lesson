package com.example.homework46_rest1.repository;

import com.example.homework46_rest1.domain.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<TeamEntity, UUID> {
}
