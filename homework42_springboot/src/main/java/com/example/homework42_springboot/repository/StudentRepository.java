package com.example.homework42_springboot.repository;

import com.example.homework42_springboot.domain.StudentDto;
import com.example.homework42_springboot.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    List<StudentEntity> findAllByOrderByNumberAsc();

    StudentEntity getById(UUID id);
}
