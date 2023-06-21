package org.example;

import java.util.ArrayList;


public class Director extends Employee {


    ArrayList<Employee> listOfSubordinate = new ArrayList<>();


    public Director() {
    }


    public void addSubordinate(Employee e) {
        listOfSubordinate.add(e);
    }

    public boolean searchSubordinateName(String name) {
        for (int i = 0; i < listOfSubordinate.size(); i++) {
            if (listOfSubordinate.get(i).getName().equals(name)) {
                System.out.println(listOfSubordinate.get(i).getName());
                return true;
            }
        }
        return false;
    }

    public boolean searchAllSubordinateName(String name) {


        for (int i = 0; i < listOfSubordinate.size(); i++) {

            if (listOfSubordinate.get(i).getName().equals(name)) {
                return true;
            } else if (listOfSubordinate.get(i) instanceof Director) {

                if (searchAllSubordinateName(listOfSubordinate.get(i).getName())) {
                    return true;
                }
            }
        }
        return false;

    }

    @Override
    public double getSalary() {
        return (super.getSalary() * listOfSubordinate.size() / 10) + super.getSalary();
    }

    @Override
    public String toString() {
        return "Type of Director: " + getType().name() +
                "{ listOfSubordinate=" + listOfSubordinate +
                '}' + "\n";
    }
}
