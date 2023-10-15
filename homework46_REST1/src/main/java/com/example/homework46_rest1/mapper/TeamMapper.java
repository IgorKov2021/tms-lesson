package com.example.homework46_rest1.mapper;

import com.example.homework46_rest1.domain.TeamEntity;
import com.example.homework46_rest1.dto.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import javax.swing.*;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TeamMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "quantityOfPlayers", source = "quantityOfPlayers")
    @Mapping(target = "type", source = "type")
    TeamDto toDto(TeamEntity teamEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "quantityOfPlayers", source = "quantityOfPlayers")
    @Mapping(target = "type", source = "type")
    TeamEntity toEntity(TeamDto dto);

    List<TeamDto> toDts(List<TeamEntity> teamEntities);

    List<TeamEntity> toEntities(List<TeamDto> teamDtos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "quantityOfPlayers", source = "quantityOfPlayers")
    @Mapping(target = "type", source = "type")
    void update(@MappingTarget TeamEntity teamEntity, TeamDto teamDto);
}
