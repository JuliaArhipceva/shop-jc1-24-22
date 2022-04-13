package org.example.shop.service;

import org.example.shop.model.Product;

public class DiscountService {

    public int countDiscount(Product product) {
        return product.getTitle().length();
    }

    public void applyDiscount(Product product, int discount) {
        double price = product.getPrice();
        int finalPriceInPercent = 100 - discount;
        double finalPrice = price * finalPriceInPercent / 100;
        product.setPrice(finalPrice);
    }

    public double countFinalPrice(double price, int discount) {
        int finalPriceInPercent = 100 - discount;
        return price * finalPriceInPercent / 100;
    }

    public void applyNegativeDiscount() {
        throw new UnsupportedOperationException("Negative discount is not allowed.");
    }
}
