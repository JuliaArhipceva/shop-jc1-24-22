package org.example.shop.model;

public abstract class Product implements Damageable {
    private String title;
    private double price;

    protected Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\r\n" +
                "Price: " + price + "\r\n";
    }
}
