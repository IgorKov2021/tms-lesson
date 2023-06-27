package org.example;

public class Child {
    private String name;
    private Integer age;
    private Sex sex;

    public Child(String name, Integer age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Child() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
