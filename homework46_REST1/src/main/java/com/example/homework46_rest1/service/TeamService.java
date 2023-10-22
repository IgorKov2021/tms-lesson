package com.example.homework46_rest1.service;

import com.example.homework46_rest1.dto.TeamDto;

import java.util.List;
import java.util.UUID;

public interface TeamService {
    List<TeamDto> getAll();

    TeamDto save(TeamDto dto);

    TeamDto getById(UUID id);

    void deleteById(UUID id);

    TeamDto update(UUID id, TeamDto dto);
}
