package org.example.shop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Product<T extends Pack> implements Damageable {
    private String title;
    private double price;
    private T pack;

    protected Product() {
    }

    protected Product(String title, double price, T pack) {
        this.title = title;
        this.price = price;
        this.pack = pack;
    }

    public void showPackInfo() {
        System.out.println(title + " is in " + pack.getLabel());
    }

    @Override
    public String toString() {
        return "Title: " + title + "\r\n" +
                "Price: " + price + "\r\n" +
                "Pack: " + pack + "\r\n";
    }
}
