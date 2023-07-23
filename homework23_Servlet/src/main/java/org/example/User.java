package org.example;

public class User {
    private String name;
    private String surname;
    private String login;
    private String email;
    private Integer age;
    private String pass;

    public User(String name, String surname, String login, String email, Integer age, String pass) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.email = email;
        this.age = age;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getPass() {
        return pass;
    }
}
