package com.example.ttbback;

import com.example.ttbback.controller.ProductController;
import com.example.ttbback.entity.Product;
import com.example.ttbback.repository.ProductRepository;
import com.example.ttbback.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TestProduct {

    @Mock
    private ProductRepository productRepository;
    private Product product;

    private ProductService productService;

    @BeforeEach
    void setup(){
        product = new Product();
        product.setId(UUID.fromString("f7129ab3-d1dd-4b66-acdd-79eb3de37bdd"));
    }

    @Test
    void shouldSaveProducts() {
        given(productRepository.save(product)).willReturn(product);
        Product expected = productService.saveProduct(product);
        assertThat(expected).isEqualTo(product);

    }

   /* @Autowired
    private MockMvc mvc;
    private static final String BASE_URL = "/product";
    @Mock
    @InjectMocks


    private Product product;
    @BeforeEach
    void setup(){
        product = new Product();
        product.setId(UUID.fromString("f7129ab3-d1dd-4b66-acdd-79eb3de37bdd"));
    }



    @Test
    void shouldReturnAllProducts() throws Exception {
        this.mvc.perform(get(BASE_URL)).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
    }

    */

}
