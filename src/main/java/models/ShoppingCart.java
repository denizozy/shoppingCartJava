package models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ShoppingCart {

    private double totalAmount=0;
    private double campaignDiscount=0;
    private double couponDiscount=0;

    ArrayList<CartItem> products = new ArrayList<>();

    public void addItem(Product product, int quantity){

        //add items to shopping cart
        CartItem item = new CartItem(product, quantity);
        products.add(item);
        totalAmount = totalAmount + (product.getProductPrice()*quantity);
    }


    public double calculateDiscount(Campaign campaign){
        String categoryTitle = campaign.getCategory().getCategoryTitle();
        int quantity = 0;
        double discount = 0;
        double totalAmountOfCategory = 0;
        for (CartItem cartItem : products) {
            Product product = cartItem.getProduct();
            Category category1 = product.getCategory();
            if (categoryTitle.equals(category1.getCategoryTitle())) {
                totalAmountOfCategory = totalAmountOfCategory + product.getProductPrice()*cartItem.getQuantity();
                quantity = quantity + cartItem.getQuantity();
            }
        }

        if(quantity>campaign.getNumberOfItems()){
            if(campaign.getDiscountType().equals("Rate")){
                discount = ((totalAmountOfCategory * campaign.getAmount()) / 100);
            }else if(campaign.getDiscountType().equals("Amount")){
                discount = campaign.getAmount();
            }
        }

        return discount;

    }

    public void applyDiscounts(double discount1, double discount2, double discount3){
        campaignDiscount = discount1;

        if(discount2> campaignDiscount){
            campaignDiscount = discount2;
        }
        if(discount3> campaignDiscount){
            campaignDiscount = discount3;
        }

        totalAmount = totalAmount - campaignDiscount;

    }

    public void applyCoupon(Coupon coupon){
        couponDiscount = 0;

        if(totalAmount > coupon.getAmount() && coupon.getDiscountType().equals("Amount")){
            couponDiscount = coupon.getDiscount();
        } else if(totalAmount > coupon.getAmount() && coupon.getDiscountType().equals("Rate")){
            couponDiscount = (totalAmount*coupon.getDiscount()/100);
        }

        totalAmount = totalAmount - couponDiscount;

    }

    public int calculateNumberOfDeliveries(){
        //number of distinct categories
        ArrayList<String> listOfCategories = new ArrayList<>();

        for (CartItem cartItem : products){
            Product product = cartItem.getProduct();
            String category = product.getCategory().getCategoryTitle();
            listOfCategories.add(category);
        }

        ArrayList uniqueList = (ArrayList) listOfCategories.stream().distinct().collect(Collectors.toList());

        return uniqueList.size();
    }

    public int calculateNumberOfProducts(){
        //number distinct products
        ArrayList<String> listOfProducts = new ArrayList<>();

        for (CartItem cartItem : products){
            String productName = cartItem.getProduct().getProductTitle();
            listOfProducts.add(productName);
        }

        ArrayList uniqueList = (ArrayList) listOfProducts.stream().distinct().collect(Collectors.toList());

        return uniqueList.size();
    }

    public double getTotalAmountAfterDiscounts(){
        return totalAmount;
    }

    public double getCouponDiscount(){
        return couponDiscount;
    }

    public double getCampaignDiscount(){
        return campaignDiscount;
    }

    public double getDeliveryCost(){
        double deliveryCost;
        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();
        deliveryCost = deliveryCostCalculator.calculateFor(calculateNumberOfDeliveries(), calculateNumberOfProducts());
        return deliveryCost;
    }

    public void printProducts(){
        System.out.println("-------------------------------------");
        System.out.println("PRODUCTS");
        System.out.println(products);
        System.out.println("-------------------------------------");
    }

    public void print(){

        System.out.println("Total Price of Shopping Cart: "+totalAmount);
        System.out.println("Total Discount: "+(couponDiscount+campaignDiscount));
        System.out.println();

        System.out.println("Total Amount: "+(totalAmount+getDeliveryCost()));
        System.out.println("Delivery Cost: " +getDeliveryCost());

    }
}
