package com.example.homework46_rest_main.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Data

public class TeamList {
    private List<TeamDto> teams;

    public TeamList() {
        teams = new ArrayList<>();
    }
}
