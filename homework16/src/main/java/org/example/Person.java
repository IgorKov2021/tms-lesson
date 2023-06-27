package org.example;


import java.util.List;

public class Person {
    private String login;
    private String name;
    private Integer age;
    private Sex sex;
    List<Child> children;

    public Person(String login, String name, Integer age, Sex sex, List<Child> children) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.children = children;
    }

    public Person() {
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", children=" + children +
                '}';
    }
}
