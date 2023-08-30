package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

public class AppSessionFactoty {
    private static AppSessionFactoty appSessionFactoty = new AppSessionFactoty();
    private static SessionFactory sessionFactory;
    public AppSessionFactoty() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/homework31");
        configuration.setProperty("hibernate.connection.username", "IgorSQL");
        configuration.setProperty("hibernate.connection.password", "123456");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        //configuration.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        configuration.setProperty(AvailableSettings.HBM2DDL_AUTO, "create-drop");
        configuration.setProperty(AvailableSettings.SHOW_SQL, "true");
        configuration.addAnnotatedClass(Car.class);
        sessionFactory = configuration.buildSessionFactory();

    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
