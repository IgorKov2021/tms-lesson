package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
            Thread thread = Thread.currentThread();
            System.out.println("Поток1 создан с помощью лямбда " + thread.getName());
            for (int i = 0; i < 10; i++) {
                System.out.println("ПОТОК1");
                try {
                    thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        Thread th2 = new Thread2();


        Myrun my1 = new Myrun();
        Thread th3 = new Thread(my1);

        th3.start();
        th3.join();
        th2.start();
        th2.join();
        th1.start();
        th1.join();



    }
}