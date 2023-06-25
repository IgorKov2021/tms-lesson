package org.example;

import java.util.ArrayList;
import java.util.List;


public class Director extends Employee {


    List<Employee> listOfSubordinate = new ArrayList<>();


    public Director() {
    }


    public void addSubordinate(Employee e) {
        listOfSubordinate.add(e);
    }

    public boolean searchSubordinateName(String name) {
        for (Employee employee : listOfSubordinate) {
            if (employee.getName().equals(name)) {
                System.out.println(employee.getName());
                return true;
            }
        }
        return false;
    }

    public boolean searchAllSubordinateName(String name) {


        for (Employee employee : listOfSubordinate) {

            if (employee.getName().equals(name)) {
                return true;
            } else if (employee instanceof Director) {
                if (((Director) employee).searchAllSubordinateName(name)) {
                    return true;
                }
            }


        }
        return false;
    }
    @Override
    public double getSalary() {
        return (super.getSalary() * ((double) listOfSubordinate.size() / 10 + 1));  // 10 % за каждого подчиненного
    }

  /*  @Override
    public String toString() {
        return "Type of Director: " + getType().name() +
                "{ listOfSubordinate=" + listOfSubordinate +
                '}';
    }*/
    @Override
    public String toString() {
        return "Type of Director: " + getType().name() + " Salary : " + getSalary()+'}' + "\n";
    }

}
