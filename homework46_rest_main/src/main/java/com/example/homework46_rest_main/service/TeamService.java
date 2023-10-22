package com.example.homework46_rest_main.service;

import com.example.homework46_rest_main.dto.TeamDto;

import java.util.List;
import java.util.UUID;

public interface TeamService {
   TeamDto getById(UUID id);
    TeamDto[] getAll();
    List<TeamDto> getAllList();
}
