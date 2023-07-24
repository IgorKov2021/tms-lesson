package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);

        System.out.println("!!!!!!!!!!!!!!!!!!!");

        ServiceStudentRealization serviceStudentRealization = new ServiceStudentRealization();
        ServiceCityRealization serviceCityRealization = new ServiceCityRealization();
        City cityMozar = new City(4, "Mozar");
        City cityBegomel = new City(5, "Begomel");
        serviceCityRealization.add(cityBegomel);
        serviceCityRealization.add(new City(1, "Gomel"));
        serviceCityRealization.add(new City(2, "Vitebsk"));
        serviceCityRealization.add(new City(3, "Minsk"));
        serviceCityRealization.add(cityMozar);
        Student newStudent = new Student(1, "Petr", "Dubrava", new Date(99, 7, 22), 5);
        serviceStudentRealization.add(newStudent);
        serviceStudentRealization.add(new Student(2, "Vadim", "Dubrovik", new Date(98, 1, 12), 2));
        serviceStudentRealization.add(new Student(3, "Egor", "Petrov", new Date(98, 1, 12), 3));
        serviceStudentRealization.showAll();
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        serviceStudentRealization.delete(newStudent);
        serviceStudentRealization.showAll();
        serviceStudentRealization.add(newStudent);
        serviceCityRealization.showAll();
        System.out.println("______________");
        serviceCityRealization.delete(cityBegomel);
        serviceCityRealization.showAll();
        serviceCityRealization.add(cityBegomel);
        serviceStudentRealization.showAll();
        serviceCityRealization.showAll();

    }
}