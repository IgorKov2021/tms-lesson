package org.example;

public class Employee {
    private String name;
    private String surname;
    private Sex sex;
    private int yearsOfExperience;
    private TypeOfWorkers type;


    public Employee(String name, String surname, Sex sex, int yearsOfExperience, TypeOfWorkers type) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.yearsOfExperience = yearsOfExperience;
        this.type = type;

    }

    public Employee() {
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

    public TypeOfWorkers getType() {
        return type;
    }



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

    public void setType(TypeOfWorkers type) {
        this.type = type;
    }

    public double getSalary() {
        double salary = ((1 + yearsOfExperience) * type.getCoefficient());
        return salary;
    }


}
