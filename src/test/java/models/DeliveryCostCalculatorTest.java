package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeliveryCostCalculatorTest {

    @Test
    void calculateFor() {

        DeliveryCostCalculator deliveryCostCalculator = new DeliveryCostCalculator();
        assertEquals(4.59, deliveryCostCalculator.calculateFor(2, 3));
    }
}