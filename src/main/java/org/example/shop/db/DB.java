package org.example.shop.db;

import org.example.shop.model.Product;
import org.example.shop.util.SerializationUtil;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * CRUD
 * Create
 * Read
 * Update
 * Delete
 */
public class DB {
    private static final int MAX_SIZE = 10;
    private static final String FILE = "db.txt";

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

    public static void save() {
        SerializationUtil.serialize(FILE, PRODUCTS);
    }

    public static void load() {
        Optional<Object> deserializedObject = SerializationUtil.deserialize(FILE);
        if (deserializedObject.isPresent()
                && deserializedObject.get() instanceof Set) {
            PRODUCTS = (Set<Product>) deserializedObject.get();
        }
    }
}
