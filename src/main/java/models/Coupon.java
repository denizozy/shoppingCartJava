package models;

public class Coupon {

    private int amount;
    private int discount;
    private String discountType;

    public Coupon(int amount, int discount, String discountType) {
        this.amount = amount;
        this.discount = discount;
        this.discountType = discountType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
}
