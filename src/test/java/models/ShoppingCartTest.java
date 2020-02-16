package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    ShoppingCart cart;
    Category food;
    Category clothing;
    Product apple;
    Product almond;
    Product skirt;
    Coupon coupon;
    Discount rate;
    Discount amount;

    @Before
    public void setup(){
        food = new Category("Food");
        clothing = new Category("Clothing");
        apple = new Product("Apple",10.5,food);
        almond = new Product("Almond", 15.2, food);
        skirt = new Product("Skirt", 25.2, clothing);
        cart = new ShoppingCart();
        rate = new RateDiscount();
        amount = new AmountDiscount();
        coupon = new Coupon(100,5,rate);
        Campaign campaign1 = new Campaign(food,10.0,3,rate);
        Campaign campaign2 = new Campaign(clothing,10.0,4,rate);
        Campaign campaign3 = new Campaign(clothing,20.0,7,rate);
        Coupon coupon = new Coupon(100, 5,rate);
        ArrayList<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign1);
        campaigns.add(campaign2);
        campaigns.add(campaign3);
    }

    @Test
    void addItem() {
        setup();
        cart.addItem(apple,2);
        assertNotNull(cart.products);
    }

    @Test
    void applyDiscounts() {
        setup();
        cart.addItem(apple,5);
        Campaign campaign1 = new Campaign(food,10.0,3,rate);
        Campaign campaign2 = new Campaign(clothing,10.0,4,rate);
        Campaign campaign3 = new Campaign(clothing,20.0,7,rate);
        ArrayList<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign1);
        campaigns.add(campaign2);
        campaigns.add(campaign3);
        cart.applyDiscounts(cart.calculateDiscount(campaigns));
        assertEquals(5.25,cart.getCampaignDiscount());
    }

    @Test
    void applyCoupon() {
        setup();
        cart.applyCoupon(coupon);
        assertEquals(0,cart.getCouponDiscount());
    }

    @Test
    void calculateNumberOfDeliveries() {
        setup();
        cart.addItem(apple,2);
        assertEquals(1,cart.calculateNumberOfDeliveries());
    }

    @Test
    void calculateNumberOfProducts() {
        setup();
        cart.addItem(apple,2);
        cart.addItem(almond,2);
        assertEquals(2,cart.calculateNumberOfProducts());
    }

    @Test
    void getTotalAmountAfterDiscounts() {
        setup();
        cart.addItem(apple,7);

        //double discount1 = cart.calculateDiscount(campaign1);
        //double discount2 = cart.calculateDiscount(campaign2);
        //double discount3 = cart.calculateDiscount(campaign3);
        //cart.applyCoupon(coupon);
        //cart.applyDiscounts(discount1,discount2,discount3);
        //assertEquals(66.15,cart.getTotalAmountAfterDiscounts());
    }

    @Test
    void getCouponDiscount() {
        setup();
        cart.addItem(apple,20);
        Coupon coupon = new Coupon(100, 5,rate);
        cart.applyCoupon(coupon);
        assertEquals(5,cart.getCouponDiscount());
    }

    @Test
    void getCampaignDiscount() {
        setup();
        cart.addItem(apple,7);
        Campaign campaign1 = new Campaign(food,10.0,3,rate);
        Campaign campaign2 = new Campaign(clothing,10.0,4,amount);
        Campaign campaign3 = new Campaign(clothing,20.0,7,amount);
        ArrayList<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign1);
        campaigns.add(campaign2);
        campaigns.add(campaign3);
        cart.applyDiscounts(cart.calculateDiscount(campaigns));
        assertEquals(66.15,cart.getTotalAmountAfterDiscounts());
    }

    @Test
    void getDeliveryCost() {
        setup();
        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();
        assertEquals(3.69,deliveryCostCalculator.calculateFor(1, 1));
    }

    @Test
    void printProducts() {
        setup();
        cart.addItem(apple,2);
        assertNotNull(cart.products);
    }

    @Test
    void print() {
        setup();
        cart.addItem(apple,2);
        assertNotNull(cart.products);
    }
}