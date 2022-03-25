package org.example.shop.db;

import org.example.shop.model.Product;

import java.util.HashSet;
import java.util.Set;

/**
 * CRUD
 * Create
 * Read
 * Update
 * Delete
 */
public class DB {
    private static final int MAX_SIZE = 2;

    private static Set<Product> PRODUCTS = new HashSet<>();

    private DB() {
    }

    public static boolean save(Product product) {
        if (PRODUCTS.size() < MAX_SIZE) {
            PRODUCTS.add(product);
            return true;
        }
        return false;
    }

    public static Set<Product> readAll() {
        return PRODUCTS;
    }
}
