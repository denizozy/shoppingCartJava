package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CampaignTest {

    Category category;
    Campaign campaign;
    Discount rate;

    @Before
    public void setup() {
        category = new Category("food");
        rate = new RateDiscount();
        campaign = new Campaign(category, 20.0, 5, rate);
    }


    @Test
    void getCategory() {
        setup();
        assertEquals("food", campaign.getCategory().getCategoryTitle());
    }

    @Test
    void setCategory() {
        setup();
        Category category2 = new Category("clothes");
        campaign.setCategory(category2);
        assertEquals("clothes", campaign.getCategory().getCategoryTitle());
    }

    @Test
    void getAmount() {
        setup();
        assertEquals(20.0, campaign.getAmount());
    }

    @Test
    void setAmount() {
        setup();
        campaign.setAmount(15.0);
        assertEquals(15.0, campaign.getAmount());
    }

    @Test
    void getNumberOfItems() {
        setup();
        assertEquals(5, campaign.getNumberOfItems());
    }

    @Test
    void setNumberOfItems() {
        setup();
        campaign.setNumberOfItems(2);
        assertEquals(2, campaign.getNumberOfItems());
    }

    @Test
    void getDiscountType() {
        setup();
        assertEquals(rate, campaign.getDiscountType());
    }

    @Test
    void setDiscountType() {
        setup();
        campaign.setDiscountType(rate);
        assertEquals(rate, campaign.getDiscountType());
    }
}