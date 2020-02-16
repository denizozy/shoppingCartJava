package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart {

    private double totalAmount = 0;
    private double campaignDiscount = 0;
    private double couponDiscount = 0;

    ArrayList<CartItem> products = new ArrayList<>();

    public void addItem(Product product, int quantity) {

        //add items to shopping cart
        CartItem item = new CartItem(product, quantity);
        products.add(item);
        totalAmount = totalAmount + (product.getProductPrice() * quantity);

    }

    public double calculateDiscount(List<Campaign> campaigns) {

        double[] discounts = new double[campaigns.size()];

        for (int i = 0; i < campaigns.size(); i++) {
            Campaign campaign = campaigns.get(i);
            if (campaign.isApplicableCampaign(products)) {
                discounts[i] = campaign.calculateDiscount(products);
            } else {
                discounts[i] = 0;
            }
        }

        Arrays.sort(discounts);

        return discounts[campaigns.size() - 1];

    }

    public void applyDiscounts(double discount) {

        campaignDiscount = discount;

        totalAmount = totalAmount - campaignDiscount;

    }

    public void applyCoupon(Coupon coupon) {
        couponDiscount = 0;

        if (coupon.isAplicableCoupon(totalAmount)) {
            couponDiscount = coupon.calculateCouponDiscount();
        }
        totalAmount = totalAmount - couponDiscount;

    }

    public int calculateNumberOfDeliveries() {
        //number of distinct categories
        ArrayList<String> listOfCategories = new ArrayList<>();

        for (CartItem cartItem : products) {
            Product product = cartItem.getProduct();
            String category = product.getCategory().getCategoryTitle();
            listOfCategories.add(category);
        }

        return (int) listOfCategories.stream().distinct().count();
    }

    public int calculateNumberOfProducts() {
        //number distinct products
        ArrayList<String> listOfProducts = new ArrayList<>();

        for (CartItem cartItem : products) {
            String productName = cartItem.getProduct().getProductTitle();
            listOfProducts.add(productName);
        }

        return (int) listOfProducts.stream().distinct().count();
    }

    public double getTotalAmountAfterDiscounts() {
        return totalAmount;
    }

    public double getCouponDiscount() {
        return couponDiscount;
    }

    public double getCampaignDiscount() {
        return campaignDiscount;
    }

    public double getDeliveryCost() {
        double deliveryCost;
        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();
        deliveryCost = deliveryCostCalculator.calculateFor(calculateNumberOfDeliveries(), calculateNumberOfProducts());
        return deliveryCost;
    }

    public void printProducts() {
        System.out.println("-------------------------------------");
        System.out.println("PRODUCTS");
        System.out.println(products);
        System.out.println("-------------------------------------");
    }

    public void print() {

        System.out.println("Total Price of Shopping Cart: " + totalAmount);
        System.out.println("Total Discount: " + (couponDiscount + campaignDiscount));
        System.out.println();

        System.out.println("Total Amount: " + (totalAmount + getDeliveryCost()));
        System.out.println("Delivery Cost: " + getDeliveryCost());

    }
}
