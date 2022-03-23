package org.example.shop.model;

import lombok.Setter;

@Setter
public class Fruit extends Product<FruitPack> {

    private boolean isFresh;
    private SweetnessLevel sweetness;

    public Fruit() {
    }

    public Fruit(String title, double price, FruitPack pack,
                 boolean isFresh, SweetnessLevel sweetness) {
        super(title, price, pack);
        this.isFresh = isFresh;
        this.sweetness = sweetness;
    }

    @Override
    public void damage() {
        System.out.println("Fruit is damaged!");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Fresh: " + isFresh + "\r\n" +
                "Sweetness: " + sweetness + "\r\n";
    }
}
