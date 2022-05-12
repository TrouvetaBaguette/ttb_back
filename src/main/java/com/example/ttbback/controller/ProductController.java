package com.example.ttbback.controller;


import com.example.ttbback.entity.Product;
import com.example.ttbback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ProductController {
    @Autowired
    private ProductService service;


    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/product")
    public List<Product> listProduct() {
        return service.getProduct();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable UUID id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByLabel(@PathVariable String name) {
        return service.getProductByLabel(name);
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@RequestBody Product product, @PathVariable UUID id) {
        service.updateProduct(product,id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        service.deleteProduct(id);
    }
}