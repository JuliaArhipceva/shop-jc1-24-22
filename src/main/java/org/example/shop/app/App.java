package org.example.shop.app;

import org.example.shop.model.Fruit;
import org.example.shop.model.FruitPack;
import org.example.shop.model.Product;
import org.example.shop.model.SweetnessLevel;
import org.example.shop.util.MenuOption;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        FruitPack applePack = new FruitPack("Apple pack");
        Fruit apple = new Fruit("Apple", 3.3, applePack,
                true, SweetnessLevel.HIGH);
        System.out.println(apple);
        products.add(apple);

        FruitPack orangePack = new FruitPack("Orange pack");
        Fruit orange = new Fruit("Orange", 5.3, orangePack,
                true, SweetnessLevel.MEDIUM);
        System.out.println(orange);
        products.add(orange);

        FruitPack bananaPack = new FruitPack("Banana pack");
        Fruit banana = new Fruit("Banana", 4.3, bananaPack,
                true, SweetnessLevel.HIGH);
        System.out.println(banana);
        products.add(banana);

        products.forEach(Product::showPackInfo);

        printMenu();
        MenuOption userChoice = retrieveUserChoice();
        switch (userChoice) {
            case SORT:
                printSortedProducts(products);
                break;
            default:
                System.out.println("No such option");
        }


//        Fruit fruitFromUser = FruitCreator.createFruit();
//        System.out.println(fruitFromUser);
    }

    private static void printMenu() {
        System.out.println("Enter " + MenuOption.SORT.getValue() + " to sort by price");
    }

    private static MenuOption retrieveUserChoice() {
        return MenuOption.SORT;
    }

    private static void printSortedProducts(List<Product> products) {
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(product -> System.out.println(product.getTitle()
                        + ": " + product.getPrice()));
    }
}
