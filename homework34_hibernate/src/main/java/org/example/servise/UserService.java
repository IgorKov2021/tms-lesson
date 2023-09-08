package org.example.servise;

import org.example.crud.Person;
import org.example.crud.StatusTask;
import org.example.crud.Task;
import org.example.crud.TypeOfUser;
import org.example.settings.AppSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserService extends AbstractService<Person> implements Updatable<Person,TypeOfUser>{
    @Override
    public void updateType(Person person, TypeOfUser type) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("update Person as p set p.type = :type where p.id = :id").
                setParameter("id", person.getId()).
                setParameter("type",type).executeUpdate();

        transaction.commit();
        session.close();
    }



    public Person getPerson(Integer id) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.find(Person.class, id);
        List<Task> tasks = person.getTasks();
        boolean empty = tasks.isEmpty();

        transaction.commit();
        session.close();

        return person;
    }
    public List<Person> getPersonsWithActiveTasks() {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        List<Person> persons = session.createQuery("SELECT  distinct t.person from Task as t where t.status = :status ").
                setParameter("status", StatusTask.IN_PROGRESS).list();
        return persons;

    }



}
