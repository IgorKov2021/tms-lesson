package org.example;

import java.util.Date;

public class Student {
    private Integer id;
    private String name;
    private String surname;
    private Date dataOfBirthday;
    private Integer id_city;


    public Student(Integer id, String name, String surname, Date dataOfBirthday, Integer id_city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dataOfBirthday = dataOfBirthday;
        this.id_city = id_city;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDataOfBirthday() {
        return dataOfBirthday;
    }

    public Integer getId_city() {
        return id_city;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dataOfBirthday=" + dataOfBirthday +
                ", id_city=" + id_city +
                '}';
    }
}
