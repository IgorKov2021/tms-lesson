package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<Child> childrenPerson1 = Arrays.asList(new Child("Petr", 16, Sex.MALE),
                new Child("Marina", 10, Sex.FEMALE));
        List<Child> childrenPerson2 = Arrays.asList(new Child("Vadim", 17, Sex.MALE),
                new Child("Oly", 8, Sex.FEMALE), new Child("Marina", 5, Sex.FEMALE));
        List<Child> childrenPerson3 = Arrays.asList(new Child("Igor", 8, Sex.MALE),
                new Child("Oleg", 5, Sex.MALE), new Child("Sergey", 3, Sex.MALE));
        List<Child> childrenPerson4 = Arrays.asList(new Child("Vika", 13, Sex.FEMALE),
                new Child("Tanya", 8, Sex.FEMALE), new Child("Oly", 14, Sex.FEMALE));

        List<Person> persons = Arrays.asList(new Person("Ig@1234", "Igor", 35, Sex.MALE, childrenPerson1),
                new Person("Vlad@3412", "Vlad", 43, Sex.MALE, childrenPerson2),
                new Person("AnnaCvetok78", "Anna", 45, Sex.FEMALE, childrenPerson3),
                new Person("SvticPushistik45", "Sveta", 45, Sex.FEMALE, childrenPerson4));

// TASK 1;
        List<Person> personsMale = persons.stream()
                .filter(person -> person.getSex() == Sex.MALE)
                .collect(Collectors.toList());
        System.out.println(personsMale);
// TASK 2
        List<Person> personWithChildren = persons.stream()
                .filter(person -> person.getChildren().size() > 2)
                .collect(Collectors.toList());
        System.out.println(personWithChildren);
//TASK3
        List<String> collect = persons.stream()
                .flatMap(person -> person.getChildren().stream())
                .filter(child -> child.getAge() > 6)
                .map(Child::getName)
                .collect(Collectors.toList());

        System.out.println(collect);
// TASK4
        List<Person> collect1 = persons.stream()
                .filter(person -> person.getSex() == Sex.FEMALE &&
                        person.getChildren().stream().anyMatch(child -> child.getAge() < 12))
                .collect(Collectors.toList());
        System.out.println(collect1);
// TASK5
        List<Integer> agesOfChildren = persons.stream()
                .flatMap(person -> person.getChildren().stream())
                .map(Child::getAge)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(agesOfChildren);


    }
}