package org.example.shop.model;

public class FruitPack implements Pack {
    private String label;

    public FruitPack(String label) {
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
