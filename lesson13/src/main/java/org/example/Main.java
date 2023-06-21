package org.example;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        Director d1 = new Director();
        d1.setName("Petr");
        d1.setSurname("Makarov");
        d1.setSex(Sex.MALE);
        d1.setYearsOfExperience(5);
        d1.setType(TypeOfWorkers.HR);


        Director d2 = new Director();
        d2.setName("Vasili");
        d2.setSurname("Ivanov");
        d2.setSex(Sex.MALE);
        d2.setYearsOfExperience(3);
        d2.setType(TypeOfWorkers.HR);

        Director d3 = new Director();
        d3.setName("Julia");
        d3.setSurname("Trofimova");
        d3.setSex(Sex.FEMALE);
        d3.setYearsOfExperience(2);
        d3.setType(TypeOfWorkers.HR);

        Director d4 = new Director();
        d4.setName("Vadim");
        d4.setSurname("Kardenok");
        d4.setSex(Sex.MALE);
        d4.setYearsOfExperience(8);
        d4.setType(TypeOfWorkers.FINANCIAL);

        Engineer e1 = new Engineer();
        e1.setName("Egor");
        e1.setSurname("Vrublev");
        e1.setType(TypeOfWorkers.AUTOMATOR);
        e1.setSex(Sex.FEMALE);
        e1.setYearsOfExperience(2);

        Engineer e2 = new Engineer();
        e2.setName("Vadim");
        e2.setSurname("Terkin");
        e2.setType(TypeOfWorkers.AUTOMATOR);
        e2.setSex(Sex.FEMALE);
        e2.setYearsOfExperience(3);

        Engineer e3 = new Engineer();
        e3.setName("Igor");
        e3.setSurname("Demidov");
        e3.setType(TypeOfWorkers.COMMUNICATOR);
        e3.setSex(Sex.FEMALE);
        e3.setYearsOfExperience(4);

        Engineer e4 = new Engineer();
        e4.setName("Anna");
        e4.setSurname("Demidova");
        e4.setType(TypeOfWorkers.COMMUNICATOR);
        e4.setSex(Sex.MALE);
        e4.setYearsOfExperience(2);

        Engineer e5 = new Engineer();
        e5.setName("Sergei");
        e5.setSurname("Nurtinov");
        e5.setType(TypeOfWorkers.ROBOTICIST);
        e5.setSex(Sex.FEMALE);
        e5.setYearsOfExperience(6);

        Engineer e6 = new Engineer();
        e6.setName("Sergei");
        e6.setSurname("Olechin");
        e6.setType(TypeOfWorkers.ROBOTICIST);
        e6.setSex(Sex.FEMALE);
        e6.setYearsOfExperience(9);

        Engineer e7 = new Engineer();
        e7.setName("Dmitry");
        e7.setSurname("Kryvko");
        e7.setType(TypeOfWorkers.ROBOTICIST);
        e7.setSex(Sex.FEMALE);
        e7.setYearsOfExperience(12);

        Engineer e8 = new Engineer();
        e8.setName("Sveta");
        e8.setSurname("Murasko");
        e8.setType(TypeOfWorkers.COMMUNICATOR);
        e8.setSex(Sex.MALE);
        e8.setYearsOfExperience(5);

        Engineer e9 = new Engineer();
        e9.setName("Marina");
        e9.setSurname("Trusak");
        e9.setType(TypeOfWorkers.COMMUNICATOR);
        e9.setSex(Sex.MALE);
        e9.setYearsOfExperience(1);

        // Создание иерархии подчинения

        d1.addSubordinate(d2);
        d1.addSubordinate(d3);
        d1.addSubordinate(e1);
        d1.addSubordinate(e2);

        d2.addSubordinate(e3);
        d2.addSubordinate(e4);

        d3.addSubordinate(e5);
        d3.addSubordinate(e6);
        d3.addSubordinate(d4);

        d4.addSubordinate(e7);
        d4.addSubordinate(e8);
        d4.addSubordinate(e9);

        System.out.println(d1.searchSubordinateName("Vasili"));
        System.out.println("------");
        System.out.println(d1.searchAllSubordinateName("Marina"));
        System.out.println("_______");
        System.out.println(d1);
        System.out.println(d1.getSalary());
        System.out.println(d1.listOfSubordinate.size());
    }
    }
