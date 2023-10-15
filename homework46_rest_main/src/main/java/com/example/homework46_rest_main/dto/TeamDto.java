package com.example.homework46_rest_main.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TeamDto {

    private UUID id;
    private String name;
    private Integer quantityOfPlayers;
    private Type type;
}

