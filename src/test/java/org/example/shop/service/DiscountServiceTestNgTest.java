package org.example.shop.service;

import org.example.shop.model.Fruit;
import org.example.shop.model.FruitPack;
import org.example.shop.model.SweetnessLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class DiscountServiceTestNgTest {

    private static DiscountService discountService;
    private Fruit apple;

    @BeforeTest
    static void setUpService() {
        discountService = new DiscountService();
        System.out.println("Discount Service was created.");
    }

    @BeforeMethod
    void setUpProduct() {
        FruitPack applePack = new FruitPack("Apple pack");
        apple = new Fruit("Apple", 3.3, applePack,
                true, SweetnessLevel.HIGH);
        System.out.println("Product was created.");
    }

    @Test
    public void testCountDiscount() {
        // when
        int discount = discountService.countDiscount(apple);

        // then
        int expected = apple.getTitle().length();
        assertEquals(discount, expected);
    }

    @Test
    void testCountDiscountNotCorrectResult() {
        // when
        int discount = discountService.countDiscount(apple);

        // then
        int expected = 3;
        assertNotEquals(discount, expected);
    }

    @Test(dataProvider = "dataProvider")
    void testCountFinalPrice(double price, int discount, double expected) {
        // when
        double finalPrice = discountService.countFinalPrice(price, discount);

        // then
        assertEquals(expected, finalPrice);
    }

    @Test(expectedExceptions = {UnsupportedOperationException.class})
    void testApplyNegativeDiscount() {
        // when -> then
        discountService.applyNegativeDiscount();
    }

    @DataProvider
    private Object[][] dataProvider() {
        return new Object[][]{
                {7.7, 7, 7.7 * 0.93},
                {2, 30, 2 * 0.7},
                {10, -10, 10 * 1.1}
        };
    }
}
