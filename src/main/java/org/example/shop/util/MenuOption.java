package org.example.shop.util;

public enum MenuOption {
    SORT(1);

    private int value;

    MenuOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
