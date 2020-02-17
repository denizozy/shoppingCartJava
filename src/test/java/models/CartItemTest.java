package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CartItemTest {

    CartItem cartItem;
    Category category;
    Product product;

    @Before
    public void setup() {
        category = new Category("food");
        product = new Product("apple", 17.0, category);
        cartItem = new CartItem(product, 3);
    }

    @Test
    void getProduct() {
        setup();
        assertEquals(product, cartItem.getProduct());
    }

    @Test
    void setProduct() {
        setup();
        product.setProductPrice(20.0);
        assertEquals(product, cartItem.getProduct());
    }

    @Test
    void getQuantity() {
        setup();
        assertEquals(3, cartItem.getQuantity());
    }

    @Test
    void setQuantity() {
        setup();
        cartItem.setQuantity(5);
        assertEquals(5, cartItem.getQuantity());
    }

    @Test
    void testToString() {
        setup();
        assertNotNull(cartItem.toString());
    }
}