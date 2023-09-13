package org.example;

import org.example.domain.User;
import org.example.impl.GeneratePairs;
import org.example.impl.ServiceStartsImpl;
import org.example.service.ServiceStarts;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        ServiceStarts serviceStarts = context.getBean(ServiceStarts.class);

        while (User.money > 0) {
            System.out.println(serviceStarts);
            serviceStarts.startRacing();
        }
        System.out.println("К сожалению у вас недостаточно средств!");
    }
}
