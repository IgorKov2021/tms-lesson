package org.example;

public interface Operations<T extends Tool>{
    void createOrder(T good);
    void addGood(T good);

    void deleteGood(T good);


}
