package org.example.shop.service;

import org.example.shop.model.Fruit;
import org.example.shop.model.FruitPack;
import org.example.shop.model.SweetnessLevel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiscountServiceJunit5Test {

    private static DiscountService discountService;
    private Fruit apple;

    @BeforeAll
    static void setUpService() {
        discountService = new DiscountService();
        System.out.println("Discount Service was created.");
    }

    @BeforeEach
    void setUpProduct() {
        FruitPack applePack = new FruitPack("Apple pack");
        apple = new Fruit("Apple", 3.3, applePack,
                true, SweetnessLevel.HIGH);
        System.out.println("Product was created.");
    }

    @Test
    void testCountDiscount() {
        // when
        int discount = discountService.countDiscount(apple);

        // then
        int expected = apple.getTitle().length();
        assertEquals(expected, discount);
    }

    @Test
    void testCountDiscountNotCorrectResult() {
        // when
        int discount = discountService.countDiscount(apple);

        // then
        int expected = 3;
        assertNotEquals(expected, discount);
    }

    @Test
    void testApplyDiscount() {
        // given
        int discount = 7;
        double expected = apple.getPrice() * (100 - discount) / 100;

        // when
        discountService.applyDiscount(apple, discount);

        // then
        assertEquals(apple.getPrice(), expected);
    }

    @ParameterizedTest
    @MethodSource("valuesForCountFinalPrice")
    void testCountFinalPrice(double price, int discount, double expected) {
        // when
        double finalPrice = discountService.countFinalPrice(price, discount);

        // then
        assertEquals(expected, finalPrice);
    }

    @Test
    void testApplyNegativeDiscount() {
        // when -> then
        assertThrows(UnsupportedOperationException.class, () ->
                discountService.applyNegativeDiscount());
    }

    private static Stream<Arguments> valuesForCountFinalPrice() {
        return Stream.of(
                Arguments.of(7.7, 7, 7.7 * 0.93),
                Arguments.of(2, 30, 2 * 0.7),
                Arguments.of(10, -10, 10 * 1.1)
        );
    }
}