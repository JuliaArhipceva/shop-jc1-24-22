package org.example.shop.app;

import org.example.shop.db.DB;
import org.example.shop.model.Fruit;
import org.example.shop.model.FruitPack;
import org.example.shop.model.Product;
import org.example.shop.model.SweetnessLevel;
import org.example.shop.repository.ProductRepository;
import org.example.shop.service.ProductService;
import org.example.shop.util.FruitCreator;
import org.example.shop.menu.Menu;
import org.example.shop.menu.MenuOption;
import org.example.shop.util.SerializationUtil;

import java.util.Comparator;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        ProductRepository repository = new ProductRepository();
        ProductService service = new ProductService(repository);

        FruitPack applePack = new FruitPack("Apple pack");
        Fruit apple = new Fruit("Apple", 3.3, applePack,
                true, SweetnessLevel.HIGH);
        SerializationUtil.serialize("temp.txt", apple);
        Fruit fr = (Fruit) SerializationUtil.deserialize("temp.txt").get();

        DB.load();


        boolean continueProgram = true;

        while (continueProgram) {
            Menu.printMenu();
            MenuOption userChoice = Menu.retrieveUserChoice();
            switch (userChoice) {
                case NEW_FRUIT:
                    Fruit fruit = FruitCreator.createFruit();
                    service.save(fruit);
                    break;
                case PRINT_ALL:
                    service.readAll().forEach(System.out::println);
                    break;
                case SORT:
                    printSortedProducts(service.readAll());
                    break;
                case STOP:
                    continueProgram = false;
                    break;
                case DEFAULT:
                    System.out.println("No such option");
            }
        }

        DB.save();
    }

    private static void printSortedProducts(Set<Product> products) {
        products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(product -> System.out.println(product.getTitle()
                        + ": " + product.getPrice()));
    }
}
