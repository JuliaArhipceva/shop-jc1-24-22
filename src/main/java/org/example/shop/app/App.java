package org.example.shop.app;

import org.example.shop.model.Fruit;
import org.example.shop.model.FruitPack;
import org.example.shop.model.Product;
import org.example.shop.model.SweetnessLevel;
import org.example.shop.repository.ProductRepository;
import org.example.shop.service.ProductService;
import org.example.shop.util.MenuOption;

import java.util.Comparator;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        ProductService service = new ProductService(repository);

        saveInitialData(service);

        service.readAll().forEach(Product::showPackInfo);

        printMenu();
        MenuOption userChoice = retrieveUserChoice();
        switch (userChoice) {
            case SORT:
                printSortedProducts(service.readAll());
                break;
            default:
                System.out.println("No such option");
        }
    }

    public static void saveInitialData(ProductService service) {
        FruitPack applePack = new FruitPack("Apple pack");
        Fruit apple = new Fruit("Apple", 3.3, applePack,
                true, SweetnessLevel.HIGH);
        service.save(apple);

        FruitPack orangePack = new FruitPack("Orange pack");
        Fruit orange = new Fruit("Orange", 5.3, orangePack,
                true, SweetnessLevel.MEDIUM);
        service.save(orange);

        FruitPack bananaPack = new FruitPack("Banana pack");
        Fruit banana = new Fruit("Banana", 4.3, bananaPack,
                true, SweetnessLevel.HIGH);
        service.save(banana);
    }

    private static void printMenu() {
        System.out.println("Enter " + MenuOption.SORT.getValue() + " to sort by price");
    }

    private static MenuOption retrieveUserChoice() {
        return MenuOption.SORT;
    }

    private static void printSortedProducts(Set<Product> products) {
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(product -> System.out.println(product.getTitle()
                        + ": " + product.getPrice()));
    }
}
