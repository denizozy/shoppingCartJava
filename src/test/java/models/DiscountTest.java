package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void calculateDiscount() {
        Discount discount = new Discount();
        assertEquals(0,discount.calculateDiscount(5,7));
    }
}