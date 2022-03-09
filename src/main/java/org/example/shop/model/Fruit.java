package org.example.shop.model;

public class Fruit extends Product {

    private boolean isFresh;
    private String sweetness;

    public Fruit(String title, double price,
                 boolean isFresh, String sweetness) {
        super(title, price);
        this.isFresh = isFresh;
        this.sweetness = sweetness;
    }

    public boolean isFresh() {
        return isFresh;
    }

    public String getSweetness() {
        return sweetness;
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
