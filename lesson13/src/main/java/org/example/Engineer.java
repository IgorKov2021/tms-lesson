package org.example;

public class Engineer extends Employee{

    public Engineer(String name, String surname, Sex sex, int yearsOfExperience, TypeOfWorkers type) {
        super(name, surname, sex, yearsOfExperience, type);
    }

    public Engineer() {
    }
    @Override
    public String toString() {
        return "Engineer{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", sex=" + getSex() +
                ", yearsOfExperience=" + getYearsOfExperience() +
                ", type=" + getType() +
                '}';
    }
}
