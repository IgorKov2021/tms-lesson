package com.example.homework42_springboot.mapper;

import com.example.homework42_springboot.domain.StudentDto;
import com.example.homework42_springboot.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.persistence.Id;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
@Mapping(target = "id", source = "id")

@Mapping(target = "name", source = "name")
@Mapping(target = "surname", source = "surname")
@Mapping(target = "course", source = "course")
@Mapping(target = "number", source = "number")

    StudentEntity toStudentEntity(StudentDto studentDto);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "surname", source = "surname")
    @Mapping(target = "course", source = "course")
    @Mapping(target = "number", source = "number")
    StudentDto toStudentDto(StudentEntity studentEntity);

    List<StudentDto> allToDto(List<StudentEntity> studentEntities);
}
