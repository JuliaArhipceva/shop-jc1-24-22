package org.example.shop.app;

import org.example.shop.model.Fruit;
import org.example.shop.model.SweetnessLevel;
import org.example.shop.util.FruitCreator;

public class App {
    public static void main(String[] args) {
        Fruit fruit = new Fruit("Apple", 3.3, true, SweetnessLevel.HIGH);
        System.out.println(fruit);

        System.out.println("Price: " + fruit.getPrice());

        Fruit fruitFromUser = FruitCreator.createFruit();
        System.out.println(fruitFromUser);
    }
}
