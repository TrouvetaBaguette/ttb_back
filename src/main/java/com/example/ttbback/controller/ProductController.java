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

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @GetMapping("/products")
    public List<Product> listProduct() {
        return service.getProduct();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable UUID id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByLabel(@PathVariable String name) {
        return service.getProductByLabel(name);
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/product/delete")
    public void deleteProduct(@PathVariable Product product) {
        service.deleteProduct(product);
    }
}
