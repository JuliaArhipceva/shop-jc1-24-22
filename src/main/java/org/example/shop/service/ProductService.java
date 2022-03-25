package org.example.shop.service;

import org.example.shop.exception.ProductNotSavedException;
import org.example.shop.model.Product;
import org.example.shop.repository.ProductRepository;

import java.util.Set;

public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
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
}
