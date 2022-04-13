package org.example.shop.service;

import org.example.shop.exception.ProductNotSavedException;
import org.example.shop.model.Product;
import org.example.shop.repository.ProductRepository;

import java.util.Random;
import java.util.Set;

public class ProductService {

    private final ProductRepository repository;
    private final DiscountService discountService;

    public ProductService(ProductRepository repository, DiscountService discountService) {
        this.repository = repository;
        this.discountService = discountService;
    }

    public void save(Product product) {
        try {
            repository.save(product);
            System.out.println("Product was successfully saved.");
        } catch (ProductNotSavedException e) {
            System.out.println(e.getMessage());
        }
    }

    public Set<Product> readAll() {
        return repository.readAll();
    }

    public double countFinalPrice(Product product) {
        int discount = new Random().nextInt(10) + 1;
        return discountService.countFinalPrice(product.getPrice(), discount);
    }
}
