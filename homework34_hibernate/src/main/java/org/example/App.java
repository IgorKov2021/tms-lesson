package org.example;

import org.example.crud.*;
import org.example.servise.TaskService;
import org.example.servise.UserService;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class App {
    public static void main(String[] args) {
        App app = new App();

        UserService userService = new UserService();
        TaskService taskService = new TaskService();

        Person person1 = app.createPerson1();
        Person person2 = app.createPerson2();
        Task task1 = app.createTask1();
        Task task2 = app.createTask2();
        Task task3 = app.createTask3();
        Task task4 = app.createTask2();

        person1.setTasks(List.of(task1,task2));
        person2.setTasks(List.of(task3,task4));

        userService.saveObject(person1);
        userService.saveObject(person2);

       taskService.updateType(task1, StatusTask.IN_PROGRESS);
        taskService.updateType(task3, StatusTask.DONE);
        taskService.updateType(task2, StatusTask.IN_PROGRESS);

        System.out.println(userService.getPersonsWithActiveTasks());




      userService.deleteObject(person1);
      userService.deleteObject(person2);







    }

    public Person createPerson1() {
        Person person1 = new Person("Vasili", new Date(78, 12, 12), Sex.MALE, TypeOfUser.ADMIN);
        return person1;
    }

    public Person createPerson2() {
        Person person2 = new Person("Ivan", new Date(56, 11, 23), Sex.MALE, TypeOfUser.USER);
        return person2;
    }
    public Task createTask1 () {
        Task task1 = new Task();
        task1.setTitle("Task1");
        task1.setDescription("You need some skills");
        task1.setStatus(StatusTask.NEW);
        return task1;
    }
    public Task createTask2 () {
        Task task1 = new Task();
        task1.setTitle("Task2");
        task1.setDescription("You need some tools");
        task1.setStatus(StatusTask.NEW);
        return task1;
    }
    public Task createTask3 () {
        Task task1 = new Task();
        task1.setTitle("Task3");
        task1.setDescription("You need food");
        task1.setStatus(StatusTask.NEW);
        return task1;
    }
}

