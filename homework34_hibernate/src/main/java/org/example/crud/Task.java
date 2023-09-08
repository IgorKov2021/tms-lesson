package org.example.crud;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    Integer id;
    private String title;
    private String description;
    @ToString.Exclude
    @ManyToOne()
    Person person;
    @Enumerated(EnumType.STRING)
    StatusTask status;

    @Version
    private Integer idLock;
}
