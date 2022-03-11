package org.example.shop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Product implements Damageable {
    private String title;
    private double price;

    protected Product() {
    }

    protected Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\r\n" +
                "Price: " + price + "\r\n";
    }
}
