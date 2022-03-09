package org.example.shop.app;

import org.example.shop.model.Fruit;

public class App {
    public static void main(String[] args) {
        Fruit fruit = new Fruit("Apple", 3.3, true, "very sweet");
        System.out.println(fruit);
    }
}
