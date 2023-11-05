package com.example.homework50_springsecurity.dto;

import com.example.homework50_springsecurity.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonDto {
    private String username;
    private String password;
    private String permission;
}
