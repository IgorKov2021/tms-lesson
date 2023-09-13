package org.example.impl;

import lombok.Data;
import org.example.domain.Pair;
import org.example.service.GenerateSpeed;

import java.util.Random;

@Data
public class GeneratePairs implements GenerateSpeed {

    Pair pair1;
    Pair pair2;
    Pair pair3;

    public GeneratePairs(Pair pair1, Pair pair2, Pair pair3) {
        this.pair1 = pair1;
        this.getPair1().setID(1);
        this.pair2 = pair2;
        this.getPair2().setID(2);
        this.pair3 = pair3;
        this.getPair3().setID(3);
    }

    @Override
    public void setSpeed() {

        pair1.setSpeed(setRandomSpeed() + pair1.getSpeed());
        pair2.setSpeed(setRandomSpeed() + pair2.getSpeed());
        pair3.setSpeed(setRandomSpeed() + pair3.getSpeed());

    }

    @Override
    public void resetSpeed() {
        pair1.setSpeed(0);
        pair2.setSpeed(0);
        pair3.setSpeed(0);
    }

    @Override
    public String toString() {
        return "Список участников:" + "\n" +
                "Участник под номером 1 = " + pair1 + "\n" +
                "Участник под номером 2 = " + pair2 + "\n" +
                "Участник под номером 3 = " + pair3;
    }

    public Integer setRandomSpeed() {
        Random random = new Random();
        int l = random.nextInt(4) + 1;
        return l;
    }
}
