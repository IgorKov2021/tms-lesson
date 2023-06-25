package org.example;

public class Eraser extends Tool{

    private String size;


    public Eraser(String customerReviews, Color color, double price, String size) {
        super(customerReviews, color, price);
        this.size = size;
    }

    @Override
    public String toString() {
        return "Eraser{" +
                "size='" + size + ", Color: " + getColor().name() + '\'' +
                '}';
    }
}
