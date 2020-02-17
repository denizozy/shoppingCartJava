package models;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {

    ArrayList<CartItem> products = new ArrayList<>();
    private double totalAmount = 0;
    private double campaignDiscount = 0;
    private double couponDiscount = 0;

    public void addItem(Product product, int quantity) {

        CartItem item = new CartItem(product, quantity);
        products.add(item);
        totalAmount = totalAmount + (product.getProductPrice() * quantity);

    }

    public double calculateDiscount(@NotNull List<Campaign> campaigns) {

        double[] discounts = new double[campaigns.size()];

        for (int i = 0; i < campaigns.size(); i++) {
            Campaign campaign = campaigns.get(i);
            if (campaign.isApplicableCampaign(products)) {
                discounts[i] = campaign.campaignDiscount(products);
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

    public void applyCoupon(@NotNull Coupon coupon) {
        couponDiscount = 0;

        if (coupon.isApplicableCoupon(totalAmount)) {
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
        //number of distinct products
        ArrayList<String> listOfProducts = new ArrayList<>();

        for (CartItem cartItem : products) {
            String productName = cartItem.getProduct().getProductTitle();
            listOfProducts.add(productName);
        }

        return (int) listOfProducts.stream().distinct().count();
    }

    public double getTotalAmountAfterDiscounts() {

        return (double) Math.round(totalAmount * 100000d) / 100000d;
    }

    public double getCouponDiscount() {
        return (double) Math.round(couponDiscount * 100000d) / 100000d;
    }

    public double getCampaignDiscount() {
        return (double) Math.round(campaignDiscount * 100000d) / 100000d;
    }

    public double getDeliveryCost() {
        double deliveryCost;
        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();
        deliveryCost = deliveryCostCalculator.calculateFor(calculateNumberOfDeliveries(), calculateNumberOfProducts());
        return deliveryCost;
    }

    public void printProducts() {

        ArrayList<String> listOfCategories = new ArrayList<>();

        for (CartItem cartItem : products) {
            Product product = cartItem.getProduct();
            String category = product.getCategory().getCategoryTitle();
            listOfCategories.add(category);
        }

        ArrayList uniqueList = (ArrayList) listOfCategories.stream().distinct().collect(Collectors.toList());

        System.out.println("-----------------------------------------------");

        for (Object o : uniqueList) {
            System.out.println("Category Name: " + o + "\n");
            for (CartItem product : products) {
                if (product.getProduct().getCategory().getCategoryTitle().equals(o)) {
                    System.out.println(product.toString());
                }
            }

        }
    }

    public void print() {

        System.out.println("-----------------------------------------------");

        System.out.println("Total Price of Shopping Cart: " + (double) Math.round(getTotalAmountAfterDiscounts() * 100000d) / 100000d);
        System.out.println("Total Discount: " + (double) Math.round((getCouponDiscount() + getCampaignDiscount()) * 100000d) / 100000d);
        System.out.println();

        System.out.println("Total Amount: " + (double) Math.round((getTotalAmountAfterDiscounts() + getDeliveryCost()) * 100000d) / 100000d);
        System.out.println("Delivery Cost: " + (double) Math.round(getDeliveryCost() * 100000d) / 100000d);

    }
}
