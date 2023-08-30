package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Storage {
    @Column(name = "Storage")
    private String address;
    private Boolean isEmptyForCar = true;
}
