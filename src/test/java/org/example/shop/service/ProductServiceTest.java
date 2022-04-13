package org.example.shop.service;

import org.example.shop.model.Fruit;
import org.example.shop.model.FruitPack;
import org.example.shop.model.SweetnessLevel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private DiscountService discountService;

    @Captor
    private ArgumentCaptor<Integer> discountCaptor;

    @Test
    void testCountFinalPrice() {
        // given
        FruitPack applePack = new FruitPack("Apple pack");
        Fruit apple = new Fruit("Apple", 3.3, applePack,
                true, SweetnessLevel.HIGH);
        when(discountService.countFinalPrice(eq(3.3), anyInt()))
                .thenReturn(3.0);

        // when
        double result = productService.countFinalPrice(apple);

        // then
        assertThat(result).isEqualTo(3.0);

        verify(discountService).countFinalPrice(eq(3.3), discountCaptor.capture());
        Integer capturedDiscount = discountCaptor.getValue();
        assertThat(capturedDiscount).isBetween(0, 10);
    }
}