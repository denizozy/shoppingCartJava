package models;

public class DeliveryCostCalculator {

    public double calculateFor(int numberOfDeliveries, int numberOfProducts) {

        double costPerDelivery = 0.5;
        double costPerProduct = 0.2;
        double fixedCost = 2.99;
        double deliveryCost;


        deliveryCost = (costPerDelivery * numberOfDeliveries) + (costPerProduct * numberOfProducts) + fixedCost;

        return (double) Math.round(deliveryCost * 100000d) / 100000d;
    }


}
