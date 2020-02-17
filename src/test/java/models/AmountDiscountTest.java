package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmountDiscountTest {

    @Test
    void calculateDiscount() {
        AmountDiscount amountDiscount = new AmountDiscount();
        assertEquals(5, amountDiscount.calculateDiscount(20, 5));
    }
}