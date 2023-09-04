package org.example.servise;

import org.example.crud.Person;
import org.example.crud.TypeOfUser;
import org.example.settings.AppSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public class AbstractService<T> {
    public T saveObject(T t) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        var object = (T)session.save(t);
        transaction.commit();
        session.close();
        return object;

    }
    public void deleteObject(T t) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(t);
        transaction.commit();
        session.close();

    }




}
