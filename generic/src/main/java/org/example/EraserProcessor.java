package org.example;

import java.util.ArrayList;

public class EraserProcessor implements Operations <Eraser>{
    ArrayList<Eraser> erasers = new ArrayList<>();
    ArrayList<Eraser> orderOfErasers = new ArrayList<>();
    @Override
    public void createOrder(Eraser good) {
        if (erasers.contains(good)) {
            orderOfErasers.add(good);
            erasers.remove(good);
            System.out.println("Заказ успешно сделан!");
            System.out.println(orderOfErasers);
        } else {
            System.out.println("Данный товар временно отсутствует в магазине!");
        }
    }

    @Override
    public void addGoods(Eraser good) {
        erasers.add(good);
    }

    @Override
    public void deleteGoods(Eraser good) {
        erasers.remove(good);
    }

    @Override
    public String toString() {
        return "EraserProcessor{" +
                "erasers=" + erasers +
                ", orderOfErasers=" + orderOfErasers +
                '}';
    }
}
