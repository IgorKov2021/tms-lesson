package org.example.servise;

import org.example.crud.Person;
import org.example.crud.TypeOfUser;
import org.example.settings.AppSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public interface Updatable <T,E> {
    public void updateType(T t, E e);


}
