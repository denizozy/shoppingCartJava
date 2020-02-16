import models.*;

import java.util.ArrayList;

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
        cart.addItem(skirt,5);
        cart.addItem(almond,1);


        Campaign campaign1 = new Campaign(food,10.0,3,"Rate");

        Campaign campaign2 = new Campaign(clothing,10.0,4,"Amount");

        Campaign campaign3 = new Campaign(clothing,20.0,7,"Amount");

        Coupon coupon = new Coupon(100, 5,"Amount");


        double discount1 = cart.calculateDiscount(campaign1);
        double discount2 = cart.calculateDiscount(campaign2);
        double discount3 = cart.calculateDiscount(campaign3);

        cart.applyDiscounts(discount1,discount2,discount3);
        cart.applyCoupon(coupon);

        cart.calculateNumberOfDeliveries();
        cart.calculateNumberOfProducts();

        cart.printProducts();

        cart.print();


    }
}