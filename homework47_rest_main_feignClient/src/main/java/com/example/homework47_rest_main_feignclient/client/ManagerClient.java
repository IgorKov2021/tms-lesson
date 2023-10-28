package com.example.homework47_rest_main_feignclient.client;

import com.example.homework47_rest_main_feignclient.dto.TeamDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@FeignClient (name = "manager-client", url = "${client.teams}")
public interface ManagerClient {
    @PostMapping
    TeamDto save(@RequestBody TeamDto dto);

    @GetMapping
    List<TeamDto> getAll();

    @GetMapping("/{id}")
    TeamDto getById(@PathVariable(name = "id") UUID id);
}
