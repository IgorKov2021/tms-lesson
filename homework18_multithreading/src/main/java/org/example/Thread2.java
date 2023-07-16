package org.example;

public class Thread2 extends Thread{
    @Override
    public void run() {
       Thread thread = Thread.currentThread();
        System.out.println("Поток2 создан через extends Thread " + thread.getName());
        for (int i = 0; i < 10; i++) {
            try {
                thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("ПОТОК2");

        }
    }
}
