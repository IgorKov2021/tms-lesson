package org.example;


public class Main {
    public static void main(String[] args) {

        Pen p1 = new Pen("Good", Color.PURPLE,123, "Ball");
        Pen p2 = new Pen("Good", Color.BLACK,150, "Gel");
        Pen p3 = new Pen("Super", Color.GREEN,140, "Fountain");
        Pen p4 = new Pen("Not Bad", Color.WHITE, 100, "Ball");

        Eraser e1 = new Eraser("Good", Color.ORANGE,14, "Big");
        Eraser e2 = new Eraser("Well", Color.WHITE,18, "Small");
        Eraser e3 = new Eraser("Bad", Color.YELLOW,15, "Big");
        Eraser e4 = new Eraser("Super", Color.BLUE,12, "Small");

        PensProcessor pensProcessor = new PensProcessor();
        System.out.println("Добавление элементов:");
        pensProcessor.addGoods(p1);
        pensProcessor.addGoods(p2);
        pensProcessor.addGoods(p3);
        pensProcessor.addGoods(p4);
        System.out.println(pensProcessor.pens);
        System.out.println("---------------------------");

        System.out.println("Удаление элементов:");
        pensProcessor.deleteGoods(p1);
        pensProcessor.deleteGoods(p2);
        System.out.println(pensProcessor.pens);
        System.out.println("--------------------------");

        pensProcessor.createOrder(p3);
        pensProcessor.createOrder(p4);
        pensProcessor.createOrder(p3);

        EraserProcessor eraserProcessor = new EraserProcessor();
        eraserProcessor.addGoods(e1);
        eraserProcessor.addGoods(e2);
        eraserProcessor.addGoods(e3);
        eraserProcessor.addGoods(e4);
        eraserProcessor.createOrder(e1);
        eraserProcessor.deleteGoods(e2);
        System.out.println(eraserProcessor.erasers);


    }
}