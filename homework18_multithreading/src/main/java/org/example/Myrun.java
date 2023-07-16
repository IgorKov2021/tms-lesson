package org.example;

public class Myrun implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("Поток3 создан через implements Runnable" + thread.getName());
        for (int i = 0; i < 10; i++) {
            try {
                thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ПОТОК3");
        }
    }

}
