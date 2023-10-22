package com.example.homework46_rest1.web;

import com.example.homework46_rest1.dto.TeamDto;
import com.example.homework46_rest1.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService service;

    @GetMapping()
    public List<TeamDto> getAll() {

        return service.getAll();
    }

    @PostMapping()
    public TeamDto createTeam(@RequestBody TeamDto dto) {
        TeamDto dtoTeam = service.save(dto);
        return dtoTeam;
    }

    @GetMapping("/{id}")
    public TeamDto getById(@PathVariable(name = "id") UUID id) {
        return service.getById(id);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") UUID id) {
        service.deleteById(id);

    }

    @PutMapping("/{id}")
    public TeamDto update(@PathVariable(name = "id") UUID id, @RequestBody TeamDto dto) {
        return service.update(id, dto);


    }
}
