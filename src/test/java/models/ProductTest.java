package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {

    Product product;
    Category category;

    @Before
    public void setup() {
        category = new Category("food");
        product = new Product("apple", 1.2, category);
    }

    @Test
    void getProductTitle() {
        setup();
        assertEquals("apple", product.getProductTitle());
    }

    @Test
    void setProductTitle() {
        setup();
        product.setProductTitle("almond");
        assertEquals("almond", product.getProductTitle());
    }

    @Test
    void getProductPrice() {
        setup();
        assertEquals(1.2, product.getProductPrice());
    }

    @Test
    void setProductPrice() {
        setup();
        product.setProductPrice(1.3);
        assertEquals(1.3, product.getProductPrice());
    }

    @Test
    void getCategory() {
        setup();
        assertEquals(category, product.getCategory());
    }

    @Test
    void setCategory() {
        setup();
        category = new Category("clothes");
        product.setCategory(category);
        assertEquals(category, product.getCategory());
    }
}