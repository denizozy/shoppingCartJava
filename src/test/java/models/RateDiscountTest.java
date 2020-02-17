package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateDiscountTest {

    @Test
    void calculateDiscount() {
        RateDiscount rateDiscount = new RateDiscount();
        assertEquals(8.7, rateDiscount.calculateDiscount(87, 10));
    }
}