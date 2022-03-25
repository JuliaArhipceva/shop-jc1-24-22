package org.example.shop.repository;

import org.example.shop.db.DB;
import org.example.shop.exception.ProductNotSavedException;
import org.example.shop.model.Product;

import java.util.Set;

public class ProductRepository {

    public void save(Product product) throws ProductNotSavedException {
        boolean isProductSaved = DB.save(product);
        if (!isProductSaved) {
            throw new ProductNotSavedException();
        }
    }

    public Set<Product> readAll() {
        return DB.readAll();
    }

}
