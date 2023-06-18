package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Director extends Employee {

    private TypeOfDirector typeOfDirector;
    ArrayList<Employee> listOfSubordinate;


    public Director(ArrayList<Employee> listOfSubordinate) {
        this.listOfSubordinate = listOfSubordinate;
    }

    public TypeOfDirector getTypeOfDirectors() {
        return typeOfDirector;
    }

    public void setTypeOfDirector(TypeOfDirector typeOfDirector) {
        this.typeOfDirector = typeOfDirector;
    }


    public int getCoefficientOfDirector() {
        return typeOfDirector.getCoefficient();
    }

    public void addSubordinate(Employee e) {
        listOfSubordinate.add(e);
    }

    public static boolean searchSubordinateName(Director director, String name) {
        for (int i = 0; i < director.listOfSubordinate.size(); i++) {
            if (director.listOfSubordinate.get(i).getName().equals(name)) {
                System.out.println(director.listOfSubordinate.get(i).getName());
                return true;
            }
        }
        return false;
    }

    public static boolean searchAllSubordinateName(Director director, String name) {


            for (int i = 0; i < director.listOfSubordinate.size(); i++) {

                if (director.listOfSubordinate.get(i).getName().equals(name)) {
                    return true;
                } else if (director.listOfSubordinate.get(i) instanceof Director) {

                    if(searchAllSubordinateName((Director) director.listOfSubordinate.get(i), name)) {
                        return true;
                    }

                } else if (director.listOfSubordinate.get(i).getName().equals(name)) {
                    System.out.println(director.listOfSubordinate.get(i).getName());
                    return true;
                }
            }
return false;

    }


    @Override
    public String toString() {
        return "\n Director{" + getName() + " " + getSurname() + " " + "Sex: " + getSex() + ", " + "YearsOfExperience: "
                +getYearsOfExperience()+ " " + "typeOfDirector=" + typeOfDirector.name() +
                ", listOfSubordinates=" + listOfSubordinate + "" +
                '}';
    }

    @Override
    public double getSalary(int coefficientOfEmployee) { // За каждого работника добавляем 10% от суммы
        return (super.getSalary(coefficientOfEmployee) * listOfSubordinate.size() * 10 / 100) +
                super.getSalary(coefficientOfEmployee);
    }


    public static void main(String[] args) {


    }
}
