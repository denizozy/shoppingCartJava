package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampaignTest {

    Category category;
    Campaign campaign;

    @Before
    public void setup() {
        category = new Category("food");
        campaign = new Campaign(category, 20.0, 5,"Rate");
    }


    @Test
    void getCategory() {
        setup();
        assertEquals("food",campaign.getCategory().getCategoryTitle());
    }

    @Test
    void setCategory() {
        setup();
        Category category2 = new Category("clothes");
        campaign.setCategory(category2);
        assertEquals("clothes",campaign.getCategory().getCategoryTitle());
    }

    @Test
    void getAmount() {
        setup();
        assertEquals(20.0,campaign.getAmount());
    }

    @Test
    void setAmount() {
        setup();
        campaign.setAmount(15.0);
        assertEquals(15.0,campaign.getAmount());
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
        assertEquals(2,campaign.getNumberOfItems());
    }

    @Test
    void getDiscountType() {
        setup();
        assertEquals("Rate",campaign.getDiscountType());
    }

    @Test
    void setDiscountType() {
        setup();
        campaign.setDiscountType("Amount");
        assertEquals("Amount",campaign.getDiscountType());
    }
}