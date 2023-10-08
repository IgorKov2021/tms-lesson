package com.example.homework42_springboot.service;

import com.example.homework42_springboot.domain.StudentDto;
import com.example.homework42_springboot.domain.StudentSearchDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {
    void save(StudentDto studentDto);

    List<StudentDto> getAll();

    List<StudentDto> sortAll();

    StudentDto upStudentPosition(UUID id);

    StudentDto downStudentPosition(UUID id);

    List<StudentDto> sortAll2();

    List<StudentDto> search(StudentSearchDto studentSearchDto);


}
