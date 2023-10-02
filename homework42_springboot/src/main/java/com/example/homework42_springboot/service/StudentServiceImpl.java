package com.example.homework42_springboot.service;

import com.example.homework42_springboot.domain.StudentDto;
import com.example.homework42_springboot.mapper.StudentMapper;
import com.example.homework42_springboot.model.StudentEntity;
import com.example.homework42_springboot.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper mapper;
    private final StudentRepository repository;

    @Override
    public void save(StudentDto studentDto) {
        StudentEntity studentEntity = mapper.toStudentEntity(studentDto);
        repository.save(studentEntity);
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentEntity> allStudents = repository.findAll();
        return mapper.allToDto(allStudents);

    }
}
