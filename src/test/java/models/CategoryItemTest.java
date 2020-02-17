package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryItemTest {

    String category;
    int quantity;
    CategoryItem categoryItem;

    @Before
    public void setup(){
        category = "food";
        quantity = 5;
        categoryItem = new CategoryItem("food",5);
    }

    @Test
    void getCategory() {
        setup();
        assertEquals("food",categoryItem.getCategory());
    }

    @Test
    void setCategory() {
        setup();
        categoryItem.setCategory("clothing");
        assertEquals("clothing",categoryItem.getCategory());
    }

    @Test
    void getQuantity() {
        setup();
        assertEquals(5,categoryItem.getQuantity());
    }

    @Test
    void setQuantity() {
        setup();
        categoryItem.setQuantity(2);
        assertEquals(2,categoryItem.getQuantity());
    }
}