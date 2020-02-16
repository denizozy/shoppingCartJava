package models;

public class RateDiscount extends Discount {

    public double calculateDiscount(double totalAmount, double discountRate) {

        double rateDiscount = (totalAmount * (discountRate / 100));

        rateDiscount = (double) Math.round(rateDiscount * 100000d) / 100000d;

        return rateDiscount;

    }
}
