package org.example.domain;

import lombok.Data;

import java.util.Random;
@Data
public class Pair {
    private Horse horse;
    private Rider rider;
    private Integer speed = 0;
    private Integer ID;

    public Pair(Horse horse, Rider rider) {
        this.horse = horse;
        this.rider = rider;
    }

    @Override
    public String toString() {
        return  horse + " " + rider;
    }
}
