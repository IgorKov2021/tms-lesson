package com.example.homework42_springboot.service;

import com.example.homework42_springboot.domain.StudentDto;
import com.example.homework42_springboot.domain.StudentSearchDto;
import com.example.homework42_springboot.mapper.StudentMapper;
import com.example.homework42_springboot.model.StudentEntity;
import com.example.homework42_springboot.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
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
    public StudentDto upStudentPosition(UUID id) {
        StudentEntity student = repository.getById(id);
        if(student.getNumber() == 0) {

        }
        student.setNewNumber((student.getNumber()) - 1);
        repository.save(student);
        return mapper.toStudentDto(student);

    }


    @Override
    public StudentDto downStudentPosition(UUID id) {
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

    @Override
    public List<StudentDto> search(StudentSearchDto studentSearchDto) {
        List<StudentEntity> searchStudents = repository.findAll(searchSpecification(studentSearchDto));
        return mapper.allToDto(searchStudents);
    }

    private Specification<StudentEntity> searchSpecification(StudentSearchDto studentSearchDto) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            String name = studentSearchDto.getName();
            if (StringUtils.isNotBlank(name)) {
                predicates.add(criteriaBuilder.equal(root.get("name"), name));
            }

            String surname = studentSearchDto.getSurname();

            if (StringUtils.isNotBlank(surname)) {
                predicates.add(criteriaBuilder.equal(root.get("surname"), surname));
            }
            Integer course = studentSearchDto.getCourse();
            if (course != null && course > 0) {
                predicates.add(criteriaBuilder.equal(root.get("course"), course));
            }

            return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
        };
    }

}
