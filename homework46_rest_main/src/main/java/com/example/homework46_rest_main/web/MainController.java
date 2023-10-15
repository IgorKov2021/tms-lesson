package com.example.homework46_rest_main.web;

import com.example.homework46_rest_main.dto.TeamDto;
import com.example.homework46_rest_main.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController

@RequestMapping("/main")
public class MainController {
    private final TeamService service;

    @GetMapping("/team")
    public TeamDto getById(@RequestParam(name = "id") UUID id) {

        return service.getById(id);
    }

    @GetMapping("/teams")
    public TeamDto[] getAll() {

        return service.getAll();
    }

    @GetMapping("/list")
    public List<TeamDto> getAllList() {

        return service.getAllList();
    }
}
