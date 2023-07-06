package org.example;

public class Engineer extends Employee{

    /*public Engineer(String name, String surname, Sex sex, int yearsOfExperience, TypeOfEmp type) {
        super(name, surname, sex, yearsOfExperience, type);
    }

    public Engineer() {
    }*/
  /*  @Override
    public String toString() {
        return "Engineer{" +
                "name='" + getName()  +
                ", surname='" + getSurname() + '\'' +
                ", sex=" + getSex() +
                ", yearsOfExperience=" + getYearsOfExperience() +
                ", type=" + getType() +
                '}';
    }*/

    @Override
    public String toString() {
        return "Engineer{" + "type=" + getType().name() + " Salary: " + getSalary() +
                '}' + "\n";
    }
}
