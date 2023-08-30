package org.example.info;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String surname;
    private String password;
    private String email;
    private String login;

    private List<Activities> userActivities;

    public User(String name, String surname, String password, String email, String login) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.login = login;
    }

    public List<Activities> getUserActivities() {
        return userActivities;
    }


    public void setUserActivities(List<Activities> userActivities) {
        this.userActivities = userActivities;
    }
    public void addActivity(Activities act) {
        if (userActivities != null) {
            List<Activities> act2 = new ArrayList<>(userActivities);
            act2.add(act);
            setUserActivities(act2);
        } else {
            setUserActivities(List.of(act));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", userActivities=" + userActivities +
                '}';
    }
}
