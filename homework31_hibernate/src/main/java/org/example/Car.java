package org.example;

import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Setter

@Entity
@Table(name = "car")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String model;

    private Boolean isPresent = false;

    @Enumerated(EnumType.STRING)
    private Color color = Color.BLUE;

    //@Column(name = "Storage")
    @Embedded
    Storage storage;
    @Temporal(TemporalType.DATE)
    Date date;
    @CreationTimestamp
    Date created;
}