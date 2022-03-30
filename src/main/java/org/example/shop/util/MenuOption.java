package org.example.shop.util;

import java.util.Arrays;
import java.util.Optional;

public enum MenuOption {

    DEFAULT(0),
    NEW_FRUIT(1),
    PRINT_ALL(2),
    SORT(3),
    STOP(4);

    private int value;

    MenuOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MenuOption convert(int neededValue) {
        Optional<MenuOption> option = Arrays.stream(values())
                .filter(menuOption -> menuOption.value == neededValue)
                .findFirst();
        return option.orElse(MenuOption.DEFAULT);
    }
}
