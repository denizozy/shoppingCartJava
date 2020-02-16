package models;

public class Campaign {

    private Category category;
    private double amount;
    private int numberOfItems;
    private String discountType;

    public Campaign(Category category, double amount, int numberOfItems, String discountType) {
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

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
}
