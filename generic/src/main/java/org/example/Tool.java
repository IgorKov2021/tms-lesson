package org.example;

public class Tool {
    private String customerReviews;
    private Color color;
    private double price;

    public Tool() {
    }

    public Tool(String customerReviews, Color color, double price) {
        this.customerReviews = customerReviews;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "customerReviews='" + customerReviews + '\'' +
                ", color=" + color +
                ", price=" + price +
                '}';
    }

    public String getCustomerReviews() {
        return customerReviews;
    }

    public Color getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }
}
