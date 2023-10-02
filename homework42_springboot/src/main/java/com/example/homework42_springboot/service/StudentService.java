package com.example.homework42_springboot.service;

import com.example.homework42_springboot.domain.StudentDto;

import java.util.List;

public interface StudentService {
    void save(StudentDto studentDto);
    List<StudentDto> getAll();
}
