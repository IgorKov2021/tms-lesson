package org.example.crud;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Enumerated(EnumType.STRING)
    TypeOfUser type;
    @OneToMany (mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true )
    List<Task> tasks;

    public Person(String name, Date dateOfBirth, Sex sex, TypeOfUser type) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.type = type;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        tasks.stream().
                forEach(task -> task.setPerson(this));
    }
    @PrePersist
    public void prePersist() {
        System.out.println("Пользователь " + this.name + " готов к сохранению!");
    }
    @PostPersist
    public void postPersist() {
        System.out.println("Пользователь " + this.name + " сохранён!");
    }
    @PostRemove
    public void postRemove() {
        System.out.println("Пользователь " + this.name + " был удален!");
    }

}
