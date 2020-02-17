package models;

import java.util.ArrayList;

public class Campaign {

    private Category category;
    private double amount;
    private int numberOfItems;
    private Discount discountType;

    public Campaign(Category category, double amount, int numberOfItems, Discount discountType) {
        this.category = category;
        this.amount = amount;
        this.numberOfItems = numberOfItems;
        this.discountType = discountType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public Discount getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Discount discountType) {
        this.discountType = discountType;
    }

    public boolean isApplicableCampaign(ArrayList<CartItem> products) {
        String categoryTitle = this.getCategory().getCategoryTitle();
        int quantity = 0;
        for (CartItem cartItem : products) {
            Product product = cartItem.getProduct();
            Category category = product.getCategory();
            if (categoryTitle.equals(category.getCategoryTitle())) {
                quantity = quantity + cartItem.getQuantity();
            }
        }
        return quantity > this.getNumberOfItems();
    }

    public double campaignDiscount(ArrayList<CartItem> products) {
        String categoryTitle = this.getCategory().getCategoryTitle();
        int quantity = 0;
        double totalAmountOfCategory = 0;
        for (CartItem cartItem : products) {
            Product product = cartItem.getProduct();
            Category category = product.getCategory();
            if (categoryTitle.equals(category.getCategoryTitle())) {
                totalAmountOfCategory = totalAmountOfCategory + product.getProductPrice() * cartItem.getQuantity();
                quantity = quantity + cartItem.getQuantity();
            }
        }

        return this.getDiscountType().calculateDiscount(totalAmountOfCategory, this.getAmount());
    }

}
