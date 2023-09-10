package org.example.domain;

import lombok.Data;

@Data
public class Horse {
    private String name;
    private Integer age;

    public Horse(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

