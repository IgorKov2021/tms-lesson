package com.example.homework47_rest_main_feignclient.service.impl;

import com.example.homework47_rest_main_feignclient.client.ManagerClient;
import com.example.homework47_rest_main_feignclient.dto.TeamDto;
import com.example.homework47_rest_main_feignclient.service.TeamService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {

    private final ManagerClient client;
    @Override
    public TeamDto save(TeamDto dto) {
       return client.save(dto);
    }

    @Override
    public List<TeamDto> getAll() {
       return client.getAll();
    }

    @Override
    public TeamDto getById(UUID id) {
        return client.getById(id);
    }
}
