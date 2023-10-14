package com.example.homework42_springboot.domain;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Random;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    private UUID id;
    private String name;
    private String surname;
    @Max(7)
    @Min(1)
    private Integer course;
    private Integer number;


    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getCourse() {
        return course;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {

        this.number = number;
    }
}
