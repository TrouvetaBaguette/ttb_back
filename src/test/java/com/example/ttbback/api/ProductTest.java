package com.example.ttbback.api;

import com.example.ttbback.entity.Ingredient;
import com.example.ttbback.entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    private Product product;
    private Ingredient i1;
    private Product p1;
    private Product p2;

    @Before
    void setUp(){
        i1 = Ingredient.builder().name("farine").build();
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(i1);
        p1 = Product.builder().label("pain").weight(0.2).ingredients(ingredients).build();
    }

    @Test
    void testCreateProduct(){
        assertEquals("pain",product.getLabel());
    }
}
