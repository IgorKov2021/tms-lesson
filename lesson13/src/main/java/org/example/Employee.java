package org.example;

public class Employee {
    private String name;
    private String surname;
    private Sex sex;
    private int yearsOfExperience;


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Sex getSex() {
        return sex;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public double getSalary(int coefficientOfEmployee) {
        double salary = coefficientOfEmployee * (yearsOfExperience + 1);
        return salary;
    }
}
