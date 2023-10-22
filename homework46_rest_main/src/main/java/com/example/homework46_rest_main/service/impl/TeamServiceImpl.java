package com.example.homework46_rest_main.service.impl;

import com.example.homework46_rest_main.config.AppConfig;
import com.example.homework46_rest_main.dto.TeamDto;
import com.example.homework46_rest_main.dto.TeamList;
import com.example.homework46_rest_main.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class TeamServiceImpl implements TeamService {

    private final RestTemplate template;

    @Override
    public TeamDto getById(UUID id) {

        TeamDto forObject = template.getForObject("http://127.0.0.1:8081/team/" + id, TeamDto.class);
        return forObject;

    }

    @Override
    public TeamDto[] getAll() {
        ResponseEntity<TeamDto[]> forEntity = template.getForEntity("http://127.0.0.1:8081/team", TeamDto[].class);
        TeamDto[] body = forEntity.getBody();
        return body;
    }

    @Override
    public List<TeamDto> getAllList() {
        //НЕ понимаю почему не работает через  TeamList.class
      /*  TeamList forObject = template.getForObject("http://127.0.0.1:8081/team", TeamList.class);
        List<TeamDto> teams = forObject.getTeams();
        return teams;*/
        ResponseEntity<List<TeamDto>> exchange = template.exchange("http://127.0.0.1:8081/team", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<TeamDto>>() {
                });


        List<TeamDto> objects = exchange.getBody();
        return objects;

    }
}
