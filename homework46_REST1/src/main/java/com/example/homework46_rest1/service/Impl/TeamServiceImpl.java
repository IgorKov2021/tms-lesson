package com.example.homework46_rest1.service.Impl;

import com.example.homework46_rest1.domain.TeamEntity;
import com.example.homework46_rest1.dto.TeamDto;
import com.example.homework46_rest1.exceptions.MyException;
import com.example.homework46_rest1.mapper.TeamMapper;
import com.example.homework46_rest1.repository.TeamRepository;
import com.example.homework46_rest1.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;
    private final TeamMapper mapper;

    @Override
    public List<TeamDto> getAll() {

        List<TeamEntity> allTeam = repository.findAll();
        return mapper.toDts(allTeam);

    }

    @Override
    public TeamDto save(TeamDto dto) {

        TeamEntity entity = mapper.toEntity(dto);
        repository.save(entity);
        return mapper.toDto(entity);

    }

    @Override
    public TeamDto getById(UUID id) {
        return mapper.toDto(repository.findById(id).orElseThrow(MyException::new));
    }

    @Override
    public void deleteById(UUID id) {

        Optional<TeamEntity> byId = repository.findById(id);

        if (byId.isPresent()) {
            repository.deleteById(id);
        }

    }

    @Transactional
    @Override
    public TeamDto update(UUID id, TeamDto dto) {

        TeamEntity byId = repository.findById(id).orElseThrow(MyException::new);
        mapper.update(byId, dto);
        return mapper.toDto(byId);

    }
}
