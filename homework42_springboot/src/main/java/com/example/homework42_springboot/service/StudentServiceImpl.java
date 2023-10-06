package com.example.homework42_springboot.service;

import com.example.homework42_springboot.domain.StudentDto;
import com.example.homework42_springboot.mapper.StudentMapper;
import com.example.homework42_springboot.model.StudentEntity;
import com.example.homework42_springboot.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper mapper;
    private final StudentRepository repository;

    @Override
    public void save(StudentDto studentDto) {
        StudentEntity studentEntity = mapper.toStudentEntity(studentDto);
        repository.save(studentEntity);
        //.save()
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentEntity> allStudents = repository.findAll();
        return mapper.allToDto(allStudents);

    }

    @Override
    public List<StudentDto> sortAll() {
        List<StudentEntity> all = repository.findAll();
        List<StudentEntity> collect = all.stream().sorted(Comparator.comparingInt(StudentEntity::getNumber)).collect(Collectors.toList());
        return mapper.allToDto(collect);
    }

    @Override
    public StudentDto upNumber(UUID id) {
        StudentEntity student = repository.getById(id);
        student.setNewNumber((student.getNumber()) - 1);
        repository.save(student);
        return mapper.toStudentDto(student);

    }


    @Override
    public StudentDto downNumber(UUID id) {
        StudentEntity byId = repository.getById(id);
        byId.setNewNumber(byId.getNumber() + 1);
        repository.save(byId);
        return mapper.toStudentDto(byId);
    }

    @Override
    public List<StudentDto> sortAll2() {
        List<StudentEntity> allByOrderByNumberAsc = repository.findAllByOrderByNumberAsc();
        return mapper.allToDto(allByOrderByNumberAsc);
    }
}
