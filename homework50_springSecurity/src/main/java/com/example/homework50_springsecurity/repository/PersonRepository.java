package com.example.homework50_springsecurity.repository;

import com.example.homework50_springsecurity.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {

Optional<PersonEntity> findByUserName(String name);
}
