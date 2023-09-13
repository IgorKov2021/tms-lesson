package org.example.servise;

import org.example.crud.Person;
import org.example.crud.StatusTask;
import org.example.crud.Task;
import org.example.settings.AppSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TaskService extends AbstractService<Task> implements Updatable<Task, StatusTask> {
    @Override
    public void updateType(Task task, StatusTask statusTask) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("update Task as t set t.status = :type where t.id = :id").
                setParameter("id", task.getId()).
                setParameter("type", statusTask).executeUpdate();

        transaction.commit();
        session.close();
    }

    public List<Task> getTasks(Person person) {
        Session session = AppSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        List<Task> tasks;
        tasks = session.createQuery("SELECT p.tasks from Person as p where p.id = :id").
                setParameter("id", person.getId()).list();
        return tasks;

    }


}
