import models.*;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public static void main(String[] args){

        Category food = new Category("Food");
        Category clothing = new Category("Clothing");
        Product apple = new Product("Apple",10.5,food);
        Product almond = new Product("Almond", 15.2, food);
        Product skirt = new Product("Skirt", 25.2, clothing);
        Product shirt = new Product("Shirt", 35.2, clothing);


        ShoppingCart cart = new ShoppingCart();

        cart.addItem(apple,7);
        cart.addItem(skirt,7);
        cart.addItem(almond,1);
        cart.addItem(shirt,1);

        RateDiscount rate = new RateDiscount();
        AmountDiscount amount = new AmountDiscount();


        Campaign campaign1 = new Campaign(food,10.0,3,rate);

        Campaign campaign2 = new Campaign(clothing,10.0,4,amount);

        Campaign campaign3 = new Campaign(clothing,20.0,7,amount);

        Coupon coupon = new Coupon(100, 5,amount);

        ArrayList<Campaign> campaigns = new ArrayList<>();
        campaigns.add(campaign1);
        campaigns.add(campaign2);
        campaigns.add(campaign3);

        double discount = cart.calculateDiscount(campaigns);

        cart.applyDiscounts(discount);

        cart.applyCoupon(coupon);

        cart.calculateNumberOfDeliveries();
        cart.calculateNumberOfProducts();

        cart.printProducts();

        cart.print();


    }
}