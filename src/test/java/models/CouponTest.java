package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CouponTest {

    Coupon coupon;

    @Before
    public void setup() {
        coupon = new Coupon(100,5,"Rate");
    }

    @Test
    void getAmount() {
        setup();
        assertEquals(100,coupon.getAmount());
    }

    @Test
    void setAmount() {
        setup();
        coupon.setAmount(150);
        assertEquals(150,coupon.getAmount());
    }

    @Test
    void getDiscount() {
        setup();
        assertEquals(5,coupon.getDiscount());
    }

    @Test
    void setDiscount() {
        setup();
        coupon.setDiscount(7);
        assertEquals(7,coupon.getDiscount());
    }

    @Test
    void getDiscountType() {
        setup();
        assertEquals("Rate",coupon.getDiscountType());
    }

    @Test
    void setDiscountType() {
        setup();
        coupon.setDiscountType("Amount");
        assertEquals("Amount",coupon.getDiscountType());
    }
}