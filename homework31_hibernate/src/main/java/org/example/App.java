package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        Session session = AppSessionFactoty.getSession();
        Car car = new Car();
        //car.setId(3);
        car.setModel("VW");
        System.out.println(car);
        Transaction transaction = session.beginTransaction();
        session.save(car);
        Storage storage = new Storage();
        storage.setAddress("Lenin street");
        car.setStorage(storage);
        Date date = new Date();
        car.setDate(date);
        transaction.commit();
        session.close();


    }
}
