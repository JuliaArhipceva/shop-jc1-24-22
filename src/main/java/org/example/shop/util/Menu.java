package org.example.shop.util;

import java.util.Scanner;

public class Menu {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("Enter " + MenuOption.SORT.getValue() + " to sort by price");
    }

    public static MenuOption retrieveUserChoice() {
        int userChoice = SCANNER.nextInt();
        return MenuOption.convert(userChoice);
    }
}
