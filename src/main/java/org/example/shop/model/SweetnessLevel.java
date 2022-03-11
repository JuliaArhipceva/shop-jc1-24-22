package org.example.shop.model;

public enum SweetnessLevel {
    LOW("Not very sweet, but still very yummy!"),
    MEDIUM("To be sweet or not to be..."),
    HIGH("Very-very-very sweet!!!");

    private String humanMessage;

    SweetnessLevel(String humanMessage) {
        this.humanMessage = humanMessage;
    }

    @Override
    public String toString() {
        return humanMessage;
    }
}
