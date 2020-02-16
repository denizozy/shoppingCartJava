package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void getCategoryTitle() {
        Category category = new Category("food");
        assertEquals("food",category.getCategoryTitle());
    }

    @Test
    void setCategoryTitle() {
        Category category = new Category("food");
        category.setCategoryTitle("clothes");
        assertEquals("clothes",category.getCategoryTitle());
    }
}