package org.example;


public class Pen extends Tool{
    private String type;

    public Pen(String customerReviews, Color color, double price, String type) {
        super(customerReviews, color, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "type='" + type + " Color " + getColor().name() + '\'' +
                '}';
    }
}




