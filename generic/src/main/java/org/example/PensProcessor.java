package org.example;

import java.util.ArrayList;

public class PensProcessor implements Operations<Pen> {

    ArrayList<Pen> pens = new ArrayList<>();
    ArrayList<Pen> order = new ArrayList<>();

    @Override
    public void addGoods(Pen good) {
        pens.add(good);
    }

    @Override
    public void deleteGoods(Pen good) {
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
