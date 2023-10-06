package com.example.homework42_springboot.service;

import com.example.homework42_springboot.domain.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    void save(StudentDto studentDto);
    List<StudentDto> getAll();

    List<StudentDto>sortAll();

    StudentDto upNumber(UUID id);
    StudentDto downNumber(UUID id);
    List<StudentDto>sortAll2();
}
