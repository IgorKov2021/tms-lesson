package org.example;

public interface Operations<T extends Tool>{
    void createOrder(T good);
    void addGoods(T good);

    void deleteGoods(T good);


}
