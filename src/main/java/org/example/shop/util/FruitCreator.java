package org.example.shop.util;

import lombok.experimental.UtilityClass;
import org.example.shop.model.Fruit;
import org.example.shop.model.SweetnessLevel;

import java.util.Scanner;

@UtilityClass
public class FruitCreator {

    private final Scanner SCANNER = new Scanner(System.in);

    public Fruit createFruit() {
        System.out.println("Create new fruit");
        Fruit fruit = new Fruit();
        fruit.setTitle(getTitleFromUser());
        fruit.setPrice(getPriceFromUser());
        fruit.setFresh(true);
        fruit.setSweetness(SweetnessLevel.MEDIUM);
        return fruit;
    }

    private String getTitleFromUser() {
        System.out.print("Title: ");
        return SCANNER.nextLine();
    }

    private double getPriceFromUser() {
        System.out.print("Price: ");
        return SCANNER.nextDouble();
    }
}
