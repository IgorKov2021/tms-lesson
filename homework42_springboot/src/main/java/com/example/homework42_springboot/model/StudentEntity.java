package com.example.homework42_springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Random;
import java.util.UUID;

// перестал работать LOMBOK поэтому добавил getter setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Students")
public class StudentEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String surname;
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
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        this.number = randomNumber;
    }

    public void setNewNumber(Integer number) {
        this.number = number;
    }
}
