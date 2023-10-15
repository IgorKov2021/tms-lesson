package com.example.homework47_rest_main_feignclient.web;

import com.example.homework47_rest_main_feignclient.dto.TeamDto;
import com.example.homework47_rest_main_feignclient.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor

@RequestMapping("/manager")
public class ManagerController {

    private final TeamService service;

    @PostMapping("/team")
    public TeamDto save(@RequestBody TeamDto dto) {
        return service.save(dto);
    }

    @GetMapping("/teams")
    public List<TeamDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/team/{id}")
    public TeamDto getById( @PathVariable(name = "id") UUID id) {
        return service.getById(id);
    }
}

