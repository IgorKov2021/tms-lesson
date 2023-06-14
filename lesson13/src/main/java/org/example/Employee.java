package org.example;

public class Employee {
    private String name;
    private String surname;
    private String sex;


    public double getSalary(int coefficientOfEmployee, int yearsOfExperience) {
        double salary = coefficientOfEmployee * (yearsOfExperience + 1);
        return salary;
    }

}
