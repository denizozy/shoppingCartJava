package models;

public class Coupon {

    private int amount;
    private int discount;
    private Discount discountType;

    public Coupon(int amount, int discount, Discount discountType) {
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

    public Discount getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Discount discountType) {
        this.discountType = discountType;
    }

    public boolean isApplicableCoupon(double totalAmount) {

        return totalAmount > this.getAmount();
    }

    public double calculateCouponDiscount() {
        return this.discountType.calculateDiscount(amount, discount);
    }
}
