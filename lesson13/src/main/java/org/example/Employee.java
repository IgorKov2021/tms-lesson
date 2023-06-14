package org.example;

public class Employee {
    private String name;
    private String surname;
    private String sex;
    private int yearsOfExperience;
    private int coefficientOfEmployee;

    public double getSalary(int coefficientOfEmployee, int yearsOfExperience) {
        double salary = coefficientOfEmployee * (yearsOfExperience + 1);
        return salary;
    }

}
