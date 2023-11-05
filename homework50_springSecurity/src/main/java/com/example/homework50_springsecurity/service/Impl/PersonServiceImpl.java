package com.example.homework50_springsecurity.service.Impl;

import com.example.homework50_springsecurity.domain.PermissionEntity;
import com.example.homework50_springsecurity.domain.PersonEntity;
import com.example.homework50_springsecurity.dto.PersonDto;
import com.example.homework50_springsecurity.repository.PersonRepository;
import com.example.homework50_springsecurity.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final PasswordEncoder encoder;

    @Override
    @Transactional
    public PersonDto save(PersonDto personDto) {

        PersonEntity person = PersonEntity.builder().userName(personDto.getUsername())
                .password(encoder.encode(personDto.getPassword()))
                .isEnabled(true).build();

        String permission = personDto.getPermission();
        String[] split = permission.split(",");
        List<PermissionEntity> permissions = Arrays.stream(split)
                .map(PermissionEntity::new)
                .peek(permissionEntity -> permissionEntity.setPerson(person))
                .collect(Collectors.toList());


        repository.save(person);

        person.setPermissionEntityList(permissions);

        return personDto;
    }
}
