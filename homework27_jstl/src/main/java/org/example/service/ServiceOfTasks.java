package org.example.service;

import org.example.info.Activities;
import org.example.info.User;

import java.util.List;

public class ServiceOfTasks {
    public List<Activities> saveTask(User user, String task) {
        ValidatorOfTasks validatorOfTasks = new ValidatorOfTasks();
        Boolean valid = validatorOfTasks.isValid(task);
        if(valid) {
            Activities act = new Activities(task);
           user.addActivity(act);
           return user.getUserActivities();
        }
        else System.out.println("ERROR!");
        return user.getUserActivities();
    }
    public void changeStatus (List<Activities> activities, String actName) {
        for (Activities act : activities) {
            if (act.getName().equals(actName)) {
                act.changeStatus();
            }

        }
    }
}
