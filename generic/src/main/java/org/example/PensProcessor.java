package org.example;

import java.util.ArrayList;
import java.util.List;

public class PensProcessor implements Operations<Pen> {

    List<Pen> pens = new ArrayList<>();
    List<Pen> order = new ArrayList<>();

    @Override
    public void addGood(Pen good) {
        pens.add(good);
    }

    @Override
    public void deleteGood(Pen good) {
        pens.remove(good);
    }


    @Override
    public void createOrder(Pen good) {
        if (pens.contains(good)) {
            order.add(good);
            pens.remove(good);
            System.out.println("Заказ успешно сделан!");
            System.out.println(order);
        } else {
            System.out.println("Данный товар временно отсутствует в магазине!");
        }
    }

    @Override
    public String toString() {
        return "{" +
                "Pens=" + pens +
                '}';
    }
}
