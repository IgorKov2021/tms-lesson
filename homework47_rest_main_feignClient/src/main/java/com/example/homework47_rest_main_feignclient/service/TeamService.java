package com.example.homework47_rest_main_feignclient.service;

import com.example.homework47_rest_main_feignclient.dto.TeamDto;

import java.util.List;
import java.util.UUID;

public interface TeamService {
    TeamDto save(TeamDto dto);
   List<TeamDto> getAll();
    TeamDto getById(UUID id);
}
