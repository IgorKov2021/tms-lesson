package org.example.settings;

import org.example.crud.Person;
import org.example.crud.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class AppSessionFactory {
   private static AppSessionFactory appSessionFactory = new AppSessionFactory();
    static SessionFactory sessionFactory;
   public AppSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.setProperty(AvailableSettings.DRIVER, "hibernate.connection.driver_class");
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/homework32");
        configuration.setProperty("hibernate.connection.username", "IgorSQL");
        configuration.setProperty("hibernate.connection.password", "123456");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        configuration.setProperty(AvailableSettings.HBM2DDL_AUTO, "create-drop");
        configuration.addAnnotatedClass(Person.class);
       configuration.addAnnotatedClass(Task.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static Session getSession() {
       return sessionFactory.openSession();
    }


}
